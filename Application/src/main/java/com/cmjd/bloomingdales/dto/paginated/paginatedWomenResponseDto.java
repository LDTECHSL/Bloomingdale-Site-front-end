package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.WomenDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedWomenResponseDto {
    private List<WomenDto> list;
    private long dataCount;
}
