package com.inditex.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @Column(name = "PRICE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brand;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String curr;

}

