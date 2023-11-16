package com.cmjd.bloomingdales.api;

import com.cmjd.bloomingdales.dto.OrderDto;
import com.cmjd.bloomingdales.dto.ShoesDto;
import com.cmjd.bloomingdales.service.OrderService;
import com.cmjd.bloomingdales.service.ShoesService;
import com.cmjd.bloomingdales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orderDetails")
@CrossOrigin
public class OrderDetails {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(new StandardResponse(
                201,"Order Saved!",orderService.saveOrder(orderDto)), HttpStatus.CREATED
        );
    }
    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllOrders(
            @RequestParam int page) {
        return new ResponseEntity<>(new StandardResponse(
                200,"List",
                orderService.getAllOrders(page)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteOrder(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                204,"Deleted!",orderService.deleteOrder(id)), HttpStatus.NO_CONTENT
        );
    }
}
