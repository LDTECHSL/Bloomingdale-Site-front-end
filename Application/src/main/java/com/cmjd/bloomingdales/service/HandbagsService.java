package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.HandbagsDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedHandbagsResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Handbags;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.HandbagsRepo;
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
public class HandbagsService {
    @Autowired
    private HandbagsRepo handbagsRepo;

    @Autowired
    private ModelMapper modelMapper;

    public HandbagsDto saveHandbags(HandbagsDto handbagsDto){
        handbagsRepo.save(modelMapper.map(handbagsDto, Handbags.class));
        return handbagsDto;
    }

    public paginatedHandbagsResponseDto getAllHandbags(int page) {

        List<Handbags> list = handbagsRepo.findAll();
        ArrayList<HandbagsDto> dtoList = new ArrayList<>();
        for (Handbags handbags:list
        ) {
            dtoList.add(new HandbagsDto(handbags.getId(),handbags.getName(),handbags.getImage(),handbags.getDescription(),
                    handbags.getPrice(),handbags.getQty()));
        }
        return new paginatedHandbagsResponseDto (dtoList, list.size());
    }

    public HandbagsDto updateHandbags(HandbagsDto handbagsDto){
        handbagsRepo.save(modelMapper.map(handbagsDto, Handbags.class));
        return handbagsDto;
    }

    public String deleteHandbags(String id){
        Optional<Handbags> tempHandbags = handbagsRepo.findById(id);
        if (tempHandbags.isPresent()){
            handbagsRepo.delete(tempHandbags.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public HandbagsDto getHandbagsByHandbagsId(String HandbagsId){
        Handbags handbags= handbagsRepo.getHandbagsByHandbagsId(HandbagsId);
        return modelMapper.map(handbags,HandbagsDto.class);
    }
}
