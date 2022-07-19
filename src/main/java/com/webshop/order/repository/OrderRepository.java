package com.webshop.order.repository;

import com.webshop.common.repository.EntityRepository;
import com.webshop.order.model.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, EntityRepository<Order> {

}
