package com.example.orderprocessor.service;

import com.example.orderprocessor.model.Item;
import com.example.orderprocessor.repository.CustomItemRepository;
import com.example.orderprocessor.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired ItemRepository itemRepo;

  @Autowired CustomItemRepository customRepo;

  @Autowired private KafkaProducer kafkaProducer;

  public void addItem(Item item) {
    itemRepo.save(item);
    kafkaProducer.sendMessage(item.getId());
  }

  public Item getItemById(String id) {
    Item item = itemRepo.findItemById(id);
    return item;
  }

  public void updateOrderStatus(String id, String orderStatus) {
    System.out.println("Updating order for " + id);
    customRepo.updateItemOrderStatus(id, orderStatus);
  }
}
