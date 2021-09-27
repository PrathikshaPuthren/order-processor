package com.example.orderprocessor.service;

import com.example.orderprocessor.model.Item;

public interface OrderService {

    public void addItem(Item item);

    public Item getItemById(String id);

    public void updateOrderStatus(String id, String orderStatus);



}
