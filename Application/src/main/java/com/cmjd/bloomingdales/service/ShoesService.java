package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.ShoesDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedShoesResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Shoes;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.ShoesRepo;
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
public class ShoesService {
    @Autowired
    private ShoesRepo shoesRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ShoesDto saveShoes(ShoesDto shoesDto){
        shoesRepo.save(modelMapper.map(shoesDto, Shoes.class));
        return shoesDto;
    }

    public paginatedShoesResponseDto getAllShoes(int page) {

        List<Shoes> list = shoesRepo.findAll();
        ArrayList<ShoesDto> dtoList = new ArrayList<>();
        for (Shoes shoes:list
        ) {
            dtoList.add(new ShoesDto(shoes.getId(),shoes.getName(),shoes.getImage(),shoes.getDescription(),
                    shoes.getPrice(),shoes.getQty()));
        }
        return new paginatedShoesResponseDto (dtoList, list.size());
    }

    public ShoesDto updateShoes(ShoesDto shoesDto){
        shoesRepo.save(modelMapper.map(shoesDto, Shoes.class));
        return shoesDto;
    }

    public String deleteShoes(String id){
        Optional<Shoes> tempShoes = shoesRepo.findById(id);
        if (tempShoes.isPresent()){
            shoesRepo.delete(tempShoes.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public ShoesDto getShoesByShoesId(String ShoesId){
        Shoes shoes= shoesRepo.getShoesByShoesId(ShoesId);
        return modelMapper.map(shoes,ShoesDto.class);
    }
}
