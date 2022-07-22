package com.webshop.order.repository;

import com.webshop.common.repository.EntityRepository;
import com.webshop.order.model.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>, EntityRepository<Item> {
}
