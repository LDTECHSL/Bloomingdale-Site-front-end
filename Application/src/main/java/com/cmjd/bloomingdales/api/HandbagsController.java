package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.HandbagsDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.HandbagsService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/handbags")
@CrossOrigin
public class HandbagsController {

    @Autowired
    private HandbagsService handbagsService;

    @PostMapping("/saveHandbags")
    public ResponseEntity<StandardResponse> saveHandbags(@RequestBody HandbagsDto handbagsDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Handbags Item Saved!",handbagsService.saveHandbags(handbagsDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateHandbags")
    public ResponseEntity<StandardResponse> updateHandbags(@RequestBody HandbagsDto handbagsDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Handbags Item Updated!",handbagsService.updateHandbags(handbagsDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteHandbags(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",handbagsService.deleteHandbags(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getHandbagsByHandbagsId/{HandbagsId}")
    public ResponseEntity<StandardResponse> getHandbagsByHandbagsId(@PathVariable String HandbagsId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",handbagsService.getHandbagsByHandbagsId(HandbagsId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllHandbags(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                handbagsService.getAllHandbags(page)), HttpStatus.OK
        );
    }

}
