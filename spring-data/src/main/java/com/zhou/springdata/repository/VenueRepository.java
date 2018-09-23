/**
 * Date:     2018/9/2316:24
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.repository;

import com.zhou.springdata.model.Venue;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/9/23  16:24
 * created by zhoumb
 */
public interface VenueRepository extends MongoRepository<Venue, String> {
}
