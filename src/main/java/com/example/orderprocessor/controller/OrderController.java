package com.example.orderprocessor.controller;

import com.example.orderprocessor.model.Item;
import com.example.orderprocessor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addItem(@RequestBody Item item){
        orderService.addItem(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "order_id") String id){
        try{
            Item itemDetails=orderService.getItemById(id);
            if(itemDetails==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(itemDetails,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{order_id}/status")
    public ResponseEntity<String> getOrderStatusById(@PathVariable(value = "order_id") String id){
        try{
            String orderStatus =orderService.getItemById(id).getOrderStatus();
            if(orderStatus == ""){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(orderStatus,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
