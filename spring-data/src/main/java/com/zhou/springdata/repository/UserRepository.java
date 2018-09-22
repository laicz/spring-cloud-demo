/**
 * Date:     2018/9/1620:34
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.repository;

import com.zhou.springdata.model.User;
import com.zhou.springdata.repository.custom.UserCustom;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/9/16  20:34
 * created by zhoumb
 */
public interface UserRepository extends MongoRepository<User,String>, UserCustom {
}
