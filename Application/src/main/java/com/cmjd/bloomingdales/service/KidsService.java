package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.KidsDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedKidsResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Kids;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.KidsRepo;
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
public class KidsService {
    @Autowired
    private KidsRepo kidsRepo;

    @Autowired
    private ModelMapper modelMapper;

    public KidsDto saveKids(KidsDto kidsDto){
        kidsRepo.save(modelMapper.map(kidsDto, Kids.class));
        return kidsDto;
    }

    public paginatedKidsResponseDto getAllKids(int page) {

        List<Kids> list = kidsRepo.findAll();
        ArrayList<KidsDto> dtoList = new ArrayList<>();
        for (Kids kids:list
        ) {
            dtoList.add(new KidsDto(kids.getId(),kids.getName(),kids.getImage(),kids.getDescription(),
                    kids.getPrice(),kids.getQty()));
        }
        return new paginatedKidsResponseDto (dtoList, list.size());
    }

    public KidsDto updateKids(KidsDto kidsDto){
        kidsRepo.save(modelMapper.map(kidsDto, Kids.class));
        return kidsDto;
    }

    public String deleteKids(String id){
        Optional<Kids> tempKids = kidsRepo.findById(id);
        if (tempKids.isPresent()){
            kidsRepo.delete(tempKids.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public KidsDto getKidsByKidsId(String KidsId){
        Kids kids= kidsRepo.getKidsByKidsId(KidsId);
        return modelMapper.map(kids,KidsDto.class);
    }
}
