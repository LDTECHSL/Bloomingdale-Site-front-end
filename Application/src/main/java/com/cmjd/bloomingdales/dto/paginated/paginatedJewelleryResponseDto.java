package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.JewelleryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedJewelleryResponseDto {
    private List<JewelleryDto> list;
    private long dataCount;
}
