/**
 * Date:     2018/9/1723:07
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.repository.custom;

import com.zhou.springdata.model.User;

import java.util.List;

/**
 * 2018/9/17  23:07
 * created by zhoumb
 */
public interface UserCustom {
    List<User> findByUserNameAndAgeAndAttribute(String userName, String age, String attribute);
}
