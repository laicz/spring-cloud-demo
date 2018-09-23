/**
 * Date:     2018/9/2316:22
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 2018/9/23  16:22
 * created by zhoumb
 */
@Document
public class Venue {
    @Id
    private String id;
    private String name;
    @GeoSpatialIndexed
    private double[] location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

}
