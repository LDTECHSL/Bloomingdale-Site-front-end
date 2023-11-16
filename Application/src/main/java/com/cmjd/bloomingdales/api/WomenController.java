package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/women")
@CrossOrigin
public class WomenController {

    @Autowired
    private WomenService womenService;

    @PostMapping("/saveWomen")
    public ResponseEntity<StandardResponse> saveWomen(@RequestBody WomenDto womenDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Women Item Saved!",womenService.saveWomen(womenDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateWomen")
    public ResponseEntity<StandardResponse> updateWomen(@RequestBody WomenDto womenDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Women Item Updated!",womenService.updateWomen(womenDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteWomen(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",womenService.deleteWomen(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getWomenByWomenId/{WomenId}")
    public ResponseEntity<StandardResponse> getWomenByWomenId(@PathVariable String WomenId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",womenService.getWomenByWomenId(WomenId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllWomen(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                womenService.getAllWomen(page)), HttpStatus.OK
        );
    }

}
