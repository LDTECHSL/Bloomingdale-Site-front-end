package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.WomenRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class WomenService {
    @Autowired
    private WomenRepo womenRepo;

    @Autowired
    private ModelMapper modelMapper;

    public WomenDto saveWomen(WomenDto womenDto){
        womenRepo.save(modelMapper.map(womenDto, Women.class));
        return womenDto;
    }

    public paginatedWomenResponseDto getAllWomen(int page) {

        List<Women> list = womenRepo.findAll();
        ArrayList<WomenDto> dtoList = new ArrayList<>();
        for (Women women:list
        ) {
            dtoList.add(new WomenDto(women.getId(),women.getName(),women.getImage(),women.getDescription(),
                    women.getPrice(),women.getQty()));
        }
        return new paginatedWomenResponseDto (dtoList, list.size());
    }

    public WomenDto updateWomen(WomenDto womenDto){
        womenRepo.save(modelMapper.map(womenDto, Women.class));
        return womenDto;
    }

    public String deleteWomen(String id){
        Optional<Women> tempWomen = womenRepo.findById(id);
        if (tempWomen.isPresent()){
            womenRepo.delete(tempWomen.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public WomenDto getWomenByWomenId(String WomenId){
       Women women= womenRepo.getWomenByWomenId(WomenId);
       return modelMapper.map(women,WomenDto.class);
    }
}
