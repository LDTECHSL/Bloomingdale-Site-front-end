package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.HomeDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.HomeService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/saveHome")
    public ResponseEntity<StandardResponse> saveHome(@RequestBody HomeDto homeDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Home Item Saved!",homeService.saveHome(homeDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateHome")
    public ResponseEntity<StandardResponse> updateHome(@RequestBody HomeDto homeDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Home Item Updated!",homeService.updateHome(homeDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteHome(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",homeService.deleteHome(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getHomeByHomeId/{HomeId}")
    public ResponseEntity<StandardResponse> getHomeByHomeId(@PathVariable String HomeId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",homeService.getHomeByHomeId(HomeId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllHome(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                homeService.getAllHome(page)), HttpStatus.OK
        );
    }

}
