package com.webshop.order.service;

import com.webshop.common.service.EntityService;
import com.webshop.common.service.EntityServiceImpl;
import com.webshop.order.dao.OrderDao;
import com.webshop.order.model.entity.Item;
import com.webshop.order.model.entity.Order;
import com.webshop.order.repository.OrderRepository;

public class OrderServiceImpl extends EntityServiceImpl<Order, OrderDao> implements OrderService {

    public OrderServiceImpl(OrderDao dao) {
        super(dao);
    }

}
