package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.HomeDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedHomeResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Home;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.HomeRepo;
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
public class HomeService {
    @Autowired
    private HomeRepo homeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public HomeDto saveHome(HomeDto homeDto){
        homeRepo.save(modelMapper.map(homeDto, Home.class));
        return homeDto;
    }

    public paginatedHomeResponseDto getAllHome(int page) {

        List<Home> list = homeRepo.findAll();
        ArrayList<HomeDto> dtoList = new ArrayList<>();
        for (Home home:list
        ) {
            dtoList.add(new HomeDto(home.getId(),home.getName(),home.getImage(),home.getDescription(),
                    home.getPrice(),home.getQty()));
        }
        return new paginatedHomeResponseDto (dtoList, list.size());
    }

    public HomeDto updateHome(HomeDto homeDto){
        homeRepo.save(modelMapper.map(homeDto, Home.class));
        return homeDto;
    }

    public String deleteHome(String id){
        Optional<Home> tempHome = homeRepo.findById(id);
        if (tempHome.isPresent()){
            homeRepo.delete(tempHome.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }

    public HomeDto getHomeByHomeId(String HomeId){
        Home home= homeRepo.getHomeByHomeId(HomeId);
        return modelMapper.map(home,HomeDto.class);
    }
}
