package com.webshop.order.dao;

import com.webshop.common.dao.EntityDaoImpl;
import com.webshop.order.model.entity.Item;
import com.webshop.order.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemDaoImpl extends EntityDaoImpl<Item, ItemRepository> implements ItemDao {

    public ItemDaoImpl(ItemRepository repository) {
        super(repository);
    }

}
