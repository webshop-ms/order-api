package com.webshop.order.facade;

import com.webshop.common.model.dto.ItemDto;
import com.webshop.common.model.dto.OrderDto;
import com.webshop.order.model.entity.Item;
import com.webshop.order.model.entity.Order;
import com.webshop.order.model.request.OrderCreateRequest;
import com.webshop.order.proxy.ItemProxy;
import com.webshop.order.service.ItemService;
import com.webshop.order.service.OrderService;
import com.webshop.order.transformer.ItemTransformer;
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

    private ItemTransformer itemTransformer;

    private ItemService itemService;

    private ItemProxy itemProxy;

    @Transactional
    public void createOrder(OrderCreateRequest orderCreateRequest) {
        // get items from item service
        List<ItemDto> itemDtos = itemProxy.getAllItemsById(orderCreateRequest.getItemIds());
        // TODO catch bad request
        if (itemDtos.isEmpty()) {
            // TODO create new custom exception class
            throw new RuntimeException("No such element");
        }
        List<Item> items = itemTransformer.dtoListToEntityList(itemDtos);
        // create and save order
        Order order = new Order();
        order.setPartnerName(orderCreateRequest.getPartnerName());
        order.setItems(items);
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
