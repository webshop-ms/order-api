package com.webshop.order.facade;

import com.webshop.common.model.dto.OrderDto;
import com.webshop.order.model.entity.Order;
import com.webshop.order.service.OrderService;
import com.webshop.order.transformer.OrderTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderFacade {

    private OrderService orderService;

    private OrderTransformer orderTransformer;

    @Transactional
    public void createOrder(OrderDto orderDto) {
        Order order = orderTransformer.dtoToEntity(orderDto);
        orderService.save(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderService.getAll();
        return orderTransformer.entityListToDtoList(orders);
    }

    @Transactional(readOnly = true)
    public OrderDto getOrder(String uuid) {
        Order order = orderService.getByUuid(uuid);
        return orderTransformer.entityToDto(order);
    }

    @Transactional
    public void deleteOrderByUuid(String uuid) {
        orderService.deleteByUuid(uuid);
    }
}
