package com.webshop.order.controller;

import com.webshop.common.model.dto.OrderDto;
import com.webshop.order.facade.OrderFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
@AllArgsConstructor
public class OrderController {

    private OrderFacade orderFacade;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderFacade.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto){
        orderFacade.createOrder(orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@RequestHeader(name = "id") String uuid){
        OrderDto orderDto = orderFacade.getOrder(uuid);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@RequestHeader(name = "id") String uuid){
        orderFacade.deleteOrderByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
