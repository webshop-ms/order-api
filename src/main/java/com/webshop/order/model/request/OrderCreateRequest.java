package com.webshop.order.model.request;

import com.webshop.common.model.entity.Identity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class OrderCreateRequest {

    @NotNull
    private String partnerName;

    @NotEmpty
    private List<@Pattern(regexp = Identity.UUID_REGEX) String> itemIds;

}
