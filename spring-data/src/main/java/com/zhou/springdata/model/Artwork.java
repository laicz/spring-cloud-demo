/**
 * Date:     2018/9/2219:06
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * 2018/9/22  19:06
 * created by zhoumb
 */
@Document
public class Artwork {
    @Id
    private String id;
    private String title;
    private String artist;
    private Integer year;
    private BigDecimal price;
    private String[] tags;

    public Artwork(String id, String title, String artist, Integer year, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.price = price;
    }

    public Artwork(String id, String title, String artist, Integer year, BigDecimal price, String[] tags) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.price = price;
        this.tags = tags;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
