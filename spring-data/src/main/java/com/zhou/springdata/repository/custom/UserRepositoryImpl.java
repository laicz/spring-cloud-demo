/**
 * Date:     2018/9/1723:08
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.repository.custom;

import com.zhou.springdata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 2018/9/17  23:08
 * created by zhoumb
 */
public class UserRepositoryImpl implements UserCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> findByUserNameAndAgeAndAttribute(String userName, String age, String attribute) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("userName").is(userName),Criteria.where("age").is(age),Criteria.where("attribute").is(attribute));
        query.addCriteria(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
