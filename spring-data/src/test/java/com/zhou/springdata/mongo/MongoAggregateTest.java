/**
 * Date:     2018/9/2217:03
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.mongo;

import com.zhou.springdata.model.Artwork;
import com.zhou.springdata.model.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.BucketOperationSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 2018/9/22  17:03
 * created by zhoumb
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoAggregateTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void printResult() {
        List<Map> maps = bucket();
        if (CollectionUtils.isEmpty(maps)) {
            System.out.println("没有结果");
            return;
        }
        for (Map map : maps) {
            System.out.println(map);
        }
    }

    public List<Map> addFields() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("id", "student", "homework").andExpression("{ $addFields:{ totalHomework: { $sum: '$homework'}}}"),
                Aggregation.unwind("homework"),
                Aggregation.group("id").sum("homework").as("totalHomework")
        );
        return aggregate(aggregation, Score.class);
    }

    public List<Map> bucket() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.bucket("price")
                        .withBoundaries(0, 200, 400)
                        .withDefaultBucket("other")  //如果存在没有在上面的数据中包含范围的时间，一定设置other  否则会报错
                        .andOutput("id").count().as("count")
                        .andOutput("title").push().as("titles")
        );
        return aggregate(aggregation, Artwork.class);
    }

    private List<Map> aggregate(Aggregation aggregation, Class clazz) {
        AggregationResults<Map> aggregate = mongoTemplate.aggregate(aggregation, clazz, Map.class);
        if (aggregate != null) {
            return aggregate.getMappedResults();
        }
        return null;
    }
}
