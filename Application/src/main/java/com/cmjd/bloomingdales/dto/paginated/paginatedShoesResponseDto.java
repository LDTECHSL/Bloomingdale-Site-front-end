package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.ShoesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedShoesResponseDto {
    private List<ShoesDto> list;
    private long dataCount;
}
