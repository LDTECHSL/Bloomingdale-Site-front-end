package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.ShoesDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.ShoesService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shoes")
@CrossOrigin
public class ShoesController {

    @Autowired
    private ShoesService shoesService;

    @PostMapping("/saveShoes")
    public ResponseEntity<StandardResponse> saveShoes(@RequestBody ShoesDto shoesDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Shoes Item Saved!",shoesService.saveShoes(shoesDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateShoes")
    public ResponseEntity<StandardResponse> updateShoes(@RequestBody ShoesDto shoesDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Shoes Item Updated!",shoesService.updateShoes(shoesDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteShoes(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",shoesService.deleteShoes(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getShoesByShoesId/{ShoesId}")
    public ResponseEntity<StandardResponse> getShoesByShoesId(@PathVariable String ShoesId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",shoesService.getShoesByShoesId(ShoesId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllShoes(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                shoesService.getAllShoes(page)), HttpStatus.OK
        );
    }

}
