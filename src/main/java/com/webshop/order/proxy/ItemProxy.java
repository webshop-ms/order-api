package com.webshop.order.proxy;

import com.webshop.common.model.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "item-service", url = "localhost:9000/api")
public interface ItemProxy {

    @GetMapping("/items/find-all-by")
    public List<ItemDto> getAllItemsById(@RequestParam(name = "uuids") List<String> ids);

}
