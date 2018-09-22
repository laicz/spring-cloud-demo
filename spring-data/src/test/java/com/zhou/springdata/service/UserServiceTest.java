/**
 * Date:     2018/9/1620:30
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.service;

import com.alibaba.fastjson.JSON;
import com.zhou.springdata.model.Artwork;
import com.zhou.springdata.model.User;
import com.zhou.springdata.repository.ArtworkRepository;
import com.zhou.springdata.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2018/9/16  20:30
 * created by zhoumb
 * 0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArtworkRepository artworkRepository;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(500);
    private static CountDownLatch countDownLatch = new CountDownLatch(500);

    @Test
    public void insertUserTest() throws InterruptedException {

        for (int j = 0; j < 5000; j++) {
            int finalJ = j;
            executorService.execute(() -> {
                for (int i = 0; i < 2000; i++) {
                    userRepository.save(new User(Thread.currentThread().getName() + (finalJ * 10000 + i), i % 2 == 0 ? "man" : "false", i % 2 != 0 ? "租客" : "房东", i + "", new Date()));
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("执行完毕");
    }

    @Test
    public void andQuery() {
        String userName = "pool-2-thread-31301631";
        String age = "租客";
        String attribute = "1631";
        List<User> users = userRepository.findByUserNameAndAgeAndAttribute(userName, age, attribute);
        for (User user : users) {
            System.out.println(JSON.toJSONString(user));
        }
    }

    @Test
    public void insertArtwork() throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    String s = String.valueOf(finalI * 1000 + j);
                    artworkRepository.save(new Artwork(s,"title:" + s,"artist:" + s,j,new BigDecimal(finalI*j)));
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("程序结束");
    }

}
