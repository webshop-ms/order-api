package com.webshop.order.service;

import com.webshop.common.service.EntityServiceImpl;
import com.webshop.order.dao.ItemDao;
import com.webshop.order.model.entity.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends EntityServiceImpl<Item, ItemDao> implements ItemService {

    public ItemServiceImpl(ItemDao dao) {
        super(dao);
    }

}
