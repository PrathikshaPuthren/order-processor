package com.example.orderprocessor.repository;

import com.example.orderprocessor.model.Item;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomItemRepositoryImpl implements CustomItemRepository {

  @Autowired MongoTemplate mongoTemplate;

  @Override
  public void updateItemOrderStatus(String id, String updatedOrderStatus) {
    Query query = new Query(Criteria.where("id").is(id));
    Update update = new Update();
    update.set("orderStatus", updatedOrderStatus);

    UpdateResult result = mongoTemplate.updateFirst(query, update, Item.class);

    if (result == null) System.out.println("No order updated");
    else {
      System.out.println(result.getModifiedCount() + " order updated..");
    }
  }
}
