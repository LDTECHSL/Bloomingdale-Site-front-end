package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.KidsDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.KidsService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kids")
@CrossOrigin
public class KidsController {

    @Autowired
    private KidsService kidsService;

    @PostMapping("/saveKids")
    public ResponseEntity<StandardResponse> saveKids(@RequestBody KidsDto kidsDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Kids Item Saved!",kidsService.saveKids(kidsDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateKids")
    public ResponseEntity<StandardResponse> updateKids(@RequestBody KidsDto kidsDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Kids Item Updated!",kidsService.updateKids(kidsDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteKids(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",kidsService.deleteKids(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getKidsByKidsId/{KidsId}")
    public ResponseEntity<StandardResponse> getKidsByKidsId(@PathVariable String KidsId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",kidsService.getKidsByKidsId(KidsId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllKids(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                kidsService.getAllKids(page)), HttpStatus.OK
        );
    }

}
