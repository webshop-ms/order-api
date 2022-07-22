package com.webshop.order.facade;

import com.webshop.order.service.ItemService;
import com.webshop.order.transformer.ItemTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemFacade {

    private ItemService itemService;

    private ItemTransformer itemTransformer;

}
