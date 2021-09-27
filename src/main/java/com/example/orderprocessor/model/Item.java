package com.example.orderprocessor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("items")
public class Item {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;
    private String orderStatus;

    public Item(String id, String name, int quantity, String category, String orderStatus) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category=category;
        this.orderStatus = orderStatus;
    }

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

    public int getItemQuantity() {
        return quantity;
    }

    public void setItemQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
