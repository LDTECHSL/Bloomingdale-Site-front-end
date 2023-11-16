package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.OrderDto;
import com.cmjd.bloomingdales.dto.ShoesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedOrder {
    private List<OrderDto> list;
    private long dataCount;
}
