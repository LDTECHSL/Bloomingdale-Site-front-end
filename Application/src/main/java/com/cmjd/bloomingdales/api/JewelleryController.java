package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.JewelleryDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.service.JewelleryService;
import com.cmjd.bloomingdales.service.WomenService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jewellery")
@CrossOrigin
public class JewelleryController {

    @Autowired
    private JewelleryService jewelleryService;

    @PostMapping("/saveJewellery")
    public ResponseEntity<StandardResponse> saveJewellery(@RequestBody JewelleryDto jewelleryDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Jewellery Item Saved!",jewelleryService.saveJewellery(jewelleryDto)), HttpStatus.CREATED
        );
    }

    @PutMapping("/updateJewellery")
    public ResponseEntity<StandardResponse> updateJewellery(@RequestBody JewelleryDto jewelleryDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Jewellery Item Updated!",jewelleryService.updateJewellery(jewelleryDto)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteJewellery(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",jewelleryService.deleteJewellery(id)), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/getJewelleryByJewelleryId/{JewelleryId}")
    public ResponseEntity<StandardResponse> getJewelleryByJewelleryId(@PathVariable String JewelleryId){
        return new ResponseEntity<>(new StandardResponse(
                200,"Data",jewelleryService.getJewelleryByJewelleryId(JewelleryId)), HttpStatus.OK
        );
    }


    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllJewellery(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                jewelleryService.getAllJewellery(page)), HttpStatus.OK
        );
    }

}
