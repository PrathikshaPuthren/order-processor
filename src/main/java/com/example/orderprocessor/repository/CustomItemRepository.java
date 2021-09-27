package com.example.orderprocessor.repository;

public interface CustomItemRepository {
  void updateItemOrderStatus(String id, String updatedOrderStatus);
}
