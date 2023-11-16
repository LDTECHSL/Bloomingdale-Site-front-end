package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.HomeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedHomeResponseDto {
    private List<HomeDto> list;
    private long dataCount;
}
