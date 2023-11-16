package com.cmjd.bloomingdales.dto.paginated;

import com.cmjd.bloomingdales.dto.MenDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedMenResponseDto {
    private List<MenDto> list;
    private long dataCount;
}
