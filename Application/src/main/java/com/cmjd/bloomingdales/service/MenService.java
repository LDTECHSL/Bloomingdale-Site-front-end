package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.MenDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedMenResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Men;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.MenRepo;
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
public class MenService {
    @Autowired
    private MenRepo menRepo;

    @Autowired
    private ModelMapper modelMapper;

    public MenDto saveMen(MenDto menDto){
        menRepo.save(modelMapper.map(menDto, Men.class));
        return menDto;
    }

    public paginatedMenResponseDto getAllMen(int page) {

        List<Men> list = menRepo.findAll();
        ArrayList<MenDto> dtoList = new ArrayList<>();
        for (Men men:list
        ) {
            dtoList.add(new MenDto(men.getId(),men.getName(),men.getImage(),men.getDescription(),
                    men.getPrice(),men.getQty()));
        }
        return new paginatedMenResponseDto (dtoList, list.size());
    }

    public MenDto updateMen(MenDto menDto){
        menRepo.save(modelMapper.map(menDto, Men.class));
        return menDto;
    }

    public String deleteMen(String id){
        Optional<Men> tempMen = menRepo.findById(id);
        if (tempMen.isPresent()){
            menRepo.delete(tempMen.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public MenDto getMenByMenId(String MenId){
        Men men= menRepo.getMenByMenId(MenId);
        return modelMapper.map(men,MenDto.class);
    }
}
