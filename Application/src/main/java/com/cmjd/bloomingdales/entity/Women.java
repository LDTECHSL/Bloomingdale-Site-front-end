package com.cmjd.bloomingdales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Women {
    @Id
    private String id;
    private String name;
    private String image;
    private String description;
    private double price;
    private double qty;
}
