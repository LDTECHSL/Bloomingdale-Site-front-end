package com.cmjd.bloomingdales.service;

import com.cmjd.bloomingdales.dto.OrderDto;
import com.cmjd.bloomingdales.dto.ShoesDto;
import com.cmjd.bloomingdales.dto.WomenDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedOrder;
import com.cmjd.bloomingdales.dto.paginated.paginatedShoesResponseDto;
import com.cmjd.bloomingdales.dto.paginated.paginatedWomenResponseDto;
import com.cmjd.bloomingdales.entity.Order;
import com.cmjd.bloomingdales.entity.Shoes;
import com.cmjd.bloomingdales.entity.Women;
import com.cmjd.bloomingdales.repo.OrderRepo;
import com.cmjd.bloomingdales.repo.ShoesRepo;
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
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDto saveOrder(OrderDto orderDto){
        orderRepo.save(modelMapper.map(orderDto, Order.class));
        return orderDto;
    }

    public paginatedOrder getAllOrders(int page) {

        List<Order> list = orderRepo.findAll();
        ArrayList<OrderDto> dtoList = new ArrayList<>();
        for (Order order:list
        ) {
            dtoList.add(new OrderDto(order.getId(),
                    order.getProductId(),order.getQty(),order.getTotal()));
        }
        return new paginatedOrder (dtoList, list.size());
    }


    public String deleteOrder(String id){
        Optional<Order> tempOrder = orderRepo.findById(id);
        if (tempOrder.isPresent()){
            orderRepo.delete(tempOrder.get());
            return id+" Deleted";
        }else {
            return "Can't find";
        }
    }
}
