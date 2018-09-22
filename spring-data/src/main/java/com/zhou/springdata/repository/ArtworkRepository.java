/**
 * Date:     2018/9/2223:07
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.repository;

import com.zhou.springdata.model.Artwork;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/9/22  23:07
 * created by zhoumb
 */
public interface ArtworkRepository extends MongoRepository<Artwork, String> {
}
