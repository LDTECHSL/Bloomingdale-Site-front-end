package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.JewelleryDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedJewelleryResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Jewellery;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.JewelleryRepo;
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
public class JewelleryService {
    @Autowired
    private JewelleryRepo jewelleryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public JewelleryDto saveJewellery(JewelleryDto jewelleryDto){
        jewelleryRepo.save(modelMapper.map(jewelleryDto, Jewellery.class));
        return jewelleryDto;
    }

    public paginatedJewelleryResponseDto getAllJewellery(int page) {

        List<Jewellery> list = jewelleryRepo.findAll();
        ArrayList<JewelleryDto> dtoList = new ArrayList<>();
        for (Jewellery jewellery:list
        ) {
            dtoList.add(new JewelleryDto(jewellery.getId(),jewellery.getName(),jewellery.getImage(),jewellery.getDescription(),
                    jewellery.getPrice(),jewellery.getQty()));
        }
        return new paginatedJewelleryResponseDto (dtoList, list.size());
    }

    public JewelleryDto updateJewellery(JewelleryDto jewelleryDto){
        jewelleryRepo.save(modelMapper.map(jewelleryDto, Jewellery.class));
        return jewelleryDto;
    }

    public String deleteJewellery(String id){
        Optional<Jewellery> tempJewellery = jewelleryRepo.findById(id);
        if (tempJewellery.isPresent()){
            jewelleryRepo.delete(tempJewellery.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public JewelleryDto getJewelleryByJewelleryId(String JewelleryId){
        Jewellery jewellery= jewelleryRepo.getJewelleryByJewelleryId(JewelleryId);
        return modelMapper.map(jewellery,JewelleryDto.class);
    }
}
