package com.webshop.order.model.entity;

import com.webshop.common.model.entity.Identity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order extends Identity {

    @Column(nullable = false)
    private String partnerName;

    @OneToMany(mappedBy = "order")
    private List<Item> items;
}
