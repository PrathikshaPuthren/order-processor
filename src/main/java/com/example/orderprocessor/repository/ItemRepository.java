package com.example.orderprocessor.repository;

import com.example.orderprocessor.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

  @Query("{id:'?0'}")
  Item findItemById(String id);

  @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
  List<Item> findAll(String category);

  public long count();
}
