package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.KidsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedKidsResponseDto {
    private List<KidsDto> list;
    private long dataCount;
}
