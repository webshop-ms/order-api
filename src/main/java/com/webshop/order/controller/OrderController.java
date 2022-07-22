package com.webshop.order.controller;

import com.webshop.common.model.dto.OrderDto;
import com.webshop.common.model.entity.Identity;
import com.webshop.order.facade.OrderFacade;
import com.webshop.order.model.request.OrderCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
@AllArgsConstructor
@Validated
public class OrderController {

    private OrderFacade orderFacade;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderFacade.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    // TODO MethodArgumentNotValidException handling like in webservice udemy project
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody @Valid OrderCreateRequest orderCreateRequest) {
        orderFacade.createOrder(orderCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable(name = "id") @Pattern(regexp = Identity.UUID_REGEX) String uuid) {
        OrderDto orderDto = orderFacade.getOrder(uuid);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(name = "id") @Pattern(regexp = Identity.UUID_REGEX) String uuid) {
        orderFacade.deleteOrderByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
