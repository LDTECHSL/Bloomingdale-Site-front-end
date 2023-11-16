package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.MenDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.MenService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/men")
@CrossOrigin
public class MenController {

    @Autowired
    private MenService menService;

    @PostMapping("/saveMen")
    public ResponseEntity<StandardResponse> saveMen(@RequestBody MenDto menDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Men Item Saved!",menService.saveMen(menDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateMen")
    public ResponseEntity<StandardResponse> updateMen(@RequestBody MenDto menDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Men Item Updated!",menService.updateMen(menDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteMen(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",menService.deleteMen(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getMenByMenId/{MenId}")
    public ResponseEntity<StandardResponse> getMenByMenId(@PathVariable String MenId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",menService.getMenByMenId(MenId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllMen(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                menService.getAllMen(page)), HttpStatus.OK
        );
    }

}
