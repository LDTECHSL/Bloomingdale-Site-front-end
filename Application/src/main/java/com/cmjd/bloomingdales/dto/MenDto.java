package com.cmjd.bloomingdales.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenDto {
    private String id;
    private String name;
    private String image;
    private String description;
    private double price;
    private double qty;
}
