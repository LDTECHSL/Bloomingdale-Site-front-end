package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.HandbagsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedHandbagsResponseDto {
    private List<HandbagsDto> list;
    private long dataCount;
}
