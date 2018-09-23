/**
 * Date:     2018/9/2321:31
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 2018/9/23  21:31
 * created by zhoumb
 */
@Document
public class Employees {
    private Integer id;
    private String name;
    private String reportsTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }
}
