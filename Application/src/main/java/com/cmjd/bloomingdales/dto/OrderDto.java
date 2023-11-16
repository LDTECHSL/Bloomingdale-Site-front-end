package com.cmjd.bloomingdales.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private String id;
    private String productId;
    private double qty;
    private double total;
}
