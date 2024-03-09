package com.inditex.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID")

    private Long id;
    @Column(name = "NAME")
    private String name;
}

