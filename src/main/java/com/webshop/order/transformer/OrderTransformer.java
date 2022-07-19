package com.webshop.order.transformer;

import com.webshop.common.model.dto.OrderDto;
import com.webshop.common.transformer.EntityTransformer;
import com.webshop.order.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderTransformer extends EntityTransformer<OrderDto, Order> {
    @Override
    public OrderDto entityToDto(Order order) {
        if (order == null){
            return null;
        }
        OrderDto dto = new OrderDto();
        dto.setId(order.getUuid());
        dto.setPartnerName(order.getPartnerName());
        return dto;
    }

    @Override
    public Order dtoToEntity(OrderDto orderDto) {
        if (orderDto == null){
            return null;
        }
        Order order = new Order();
        order.setUuid(orderDto.getId());
        order.setPartnerName(orderDto.getPartnerName());
        return order;
    }
}