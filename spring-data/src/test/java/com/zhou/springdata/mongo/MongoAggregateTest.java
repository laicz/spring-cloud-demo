/**
 * Date:     2018/9/2217:03
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.mongo;

import com.zhou.springdata.model.Artwork;
import com.zhou.springdata.model.Employees;
import com.zhou.springdata.model.Score;
import com.zhou.springdata.model.Venue;
import com.zhou.springdata.repository.VenueRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.FacetOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 2018/9/22  17:03
 * created by zhoumb
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoAggregateTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private VenueRepository venueRepository;

    @Test
    public void printResult() {
        List<Map> maps = graphLookup();
        if (CollectionUtils.isEmpty(maps)) {
            System.out.println("没有结果");
            return;
        }
        for (Map map : maps) {
            System.out.println(map);
        }
    }

    /**
     * addFields   暂时没有找到用法  可以使用这种方法来代替原来的用法
     *
     * @return
     */
    public List<Map> addFields() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("id", "student", "homework").andExpression("{ $addFields:{ totalHomework: { $sum: '$homework'}}}"),
                Aggregation.unwind("homework"),
                Aggregation.group("id").sum("homework").as("totalHomework")
        );
        return aggregate(aggregation, Score.class);
    }

    /**
     * bucket 水桶 ，可以将数字类型的数据来设定范围，进行聚合统计
     *
     * @return
     */
    public List<Map> bucket() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.bucket("price")
                        .withBoundaries(0, 200, 400)
                        .withDefaultBucket("other")  //如果存在没有在上面的数据中包含范围的时间，一定设置other  否则会报错
                        .andOutput("id").count().as("count")
//                        .andOutput("title").push().as("titles")
        );
        return aggregate(aggregation, Artwork.class);
    }

    /**
     * 给特定的列来指定分区的个数，让他自己来进行分区并返回分区的大小范围及设定的
     *
     * @return
     */
    public List<Map> _bucketAuto() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.bucketAuto("price", 500)
        );
        return aggregate(aggregation, Artwork.class);
    }

    public List<Map> multiBucketAuto() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.facet(
//                        Aggregation.bucket()
                )
        );
        return aggregate(aggregation, Artwork.class);
    }

    public List<Map> _bucketAuto(int partion) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.bucketAuto("price", partion)
        );
        return aggregate(aggregation, Artwork.class);
    }

    /**
     * 无此实现
     *
     * @return
     */
    public List<Map> collStats() {
        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.
        );
        return aggregate(aggregation, Artwork.class);
    }

    /**
     * 无此实现
     *
     * @return
     */
    public List<Map> currentOp() {
        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.op
        );
        return aggregate(aggregation, Artwork.class);
    }

    /**
     * count 的用法  返回聚合操作的最后的数据数量
     * 在聚合最后使用
     *
     * @return
     */
    public List<Map> count() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("price").gt(100)),
                Aggregation.count().as("passing_price")
        );
        return aggregate(aggregation, Artwork.class);
    }

    /**
     * 在同一输入文档集中的同一阶段处理多个聚合管道
     * 每个子管道在输出文档中都有自己的字段，其结果存储为一个文档数组
     * $facet阶段允许您创建多个方面的聚合，这些聚合可以在单个聚合阶段中描述跨多个维度或多个方面的数据。
     * 多面聚合提供了多个过滤器和分类来指导数据浏览和分析。
     * 零售商通常使用faceting来缩小搜索结果，方法是在产品价格、制造商、大小等方面创建过滤器。
     *
     * @return
     */
    public List<Map> _facet() {
        /*FacetOperation facet = Aggregation.facet();
        FacetOperation categorizedByPrice = facet.and(Aggregation.match(Criteria.where("price").exists(true)),
                Aggregation.bucket("price")
                        .withBoundaries(0, 150, 200, 300, 400)
                        .withDefaultBucket("other")
                        .andOutput("id").count().as("count")).as("categorizedByPrice");
        FacetOperation categorizedByTags = facet.and(Aggregation.match(Criteria.where("tags").exists(true)),
                Aggregation.unwind("tags"),
                Aggregation.group("id").count().as("tagSize"),
                Aggregation.sort(new Sort(Sort.Direction.ASC, "tagSize"))).as("categorizedByTags");
        Aggregation aggregation = Aggregation.newAggregation(
//                categorizedByPrice,
                categorizedByTags
//                facet
                *//*Aggregation.facet(
//                        Aggregation.project("price","tags"),
                        Aggregation.match(Criteria.where("price").exists(true)),
                        Aggregation.bucketAuto("price", 10)
                ).as("categorizedByPrice(Auto)"),*//*
         *//*Aggregation.facet(
                        Aggregation.match(Criteria.where("tags").exists(true)),
                        Aggregation.unwind("tags"),
                        Aggregation.group("id").count().as("tagSize"),
                        Aggregation.sort(new Sort(Sort.Direction.ASC, "tagSize"))
                ).as("categorizedByCountry"),*//*
         *//*Aggregation.facet(
                        Aggregation.match(Criteria.where("price").exists(true)),
                        Aggregation.bucket("price")
                                .withBoundaries(0, 150, 200, 300, 400)
                                .withDefaultBucket("other")
                                .andOutput("id").count().as("count")
                ).as("categorizedByPrice")*//*
         *//* Aggregation.facet(
                        Aggregation.match(Criteria.where("year").exists(true)),
                        Aggregation.bucketAuto("year", 20)
                ).as("categorizedByYears(Auto)")*//*
        );*/
        FacetOperation categorizedByPrice = facet(match(Criteria.where("price").exists(true)), bucketAuto("price", 5)).as("categorizedByPrice");
        FacetOperation categorizedByCountry = facet(match(Criteria.where("tags").exists(true)), unwind("tags"), group("id").count().as("tagSize"), sort(new Sort(Sort.Direction.ASC, "tagSize"))).as("categorizedByCountry");
        Aggregation aggregation = newAggregation(categorizedByPrice/*, categorizedByCountry*/);
        return aggregate(aggregation, Artwork.class);
    }

    public List<Map> geoNear() {
        Point location = new Point(0.77, 0.33);
        NearQuery nearQuery = NearQuery.near(location).maxDistance(new Distance(100000, Metrics.MILES));
        Aggregation aggregation = newAggregation(
                Aggregation.geoNear(nearQuery, "location")
        );
        return aggregate(aggregation, Venue.class);
    }

    private List<Map> aggregate(Aggregation aggregation, Class clazz) {
        AggregationResults<Map> aggregate = mongoTemplate.aggregate(aggregation, clazz, Map.class);
        if (aggregate != null) {
            return aggregate.getMappedResults();
        }
        return null;
    }

    /**
     * 相当于实现树形关系  找到自己要负责的东西
     *
     * @return
     */
    public List<Map> graphLookup() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.graphLookup("employees")
                        .startWith("reportsTo")
                        .connectFrom("reportsTo")
                        .connectTo("name")
                        .as("reportingHierarchy")
        );
        return aggregate(aggregation, Employees.class);
    }

    @Test
    public void yali() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i < 100; i++) {
                        _bucketAuto(i);
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
    }

    @Test
    public void insertVenue() {
        for (int i = 0; i < 10000; i++) {
            Venue venue = new Venue();
            venue.setLocation(new double[]{new Random().nextDouble(), new Random().nextDouble()});
            venueRepository.save(venue);
        }
    }
}
