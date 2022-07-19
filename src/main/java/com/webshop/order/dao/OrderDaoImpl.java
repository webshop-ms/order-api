package com.webshop.order.dao;

import com.webshop.common.dao.EntityDao;
import com.webshop.common.dao.EntityDaoImpl;
import com.webshop.order.model.entity.Order;
import com.webshop.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDaoImpl extends EntityDaoImpl<Order, OrderRepository> implements OrderDao {

    public OrderDaoImpl(OrderRepository repository) {
        super(repository);
    }
}
