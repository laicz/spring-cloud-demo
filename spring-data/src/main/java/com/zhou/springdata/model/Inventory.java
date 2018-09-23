/**
 * Date:     2018/9/2323:07
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 2018/9/23  23:07
 * created by zhoumb
 */
@Document
public class Inventory {
    @Id
    private String id;
    private String item;
    private String description;
    private Integer qty;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
