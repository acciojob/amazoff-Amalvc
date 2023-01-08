package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void addOrderService(Order order){

        orderRepository.addOrderRepository(order);
    }
    public void addPartnerService(String partnerId){

        orderRepository.addPartnerRepository(partnerId);
    }
    public void addOrderPartnerPairService(String orderId,String partnerId){

        orderRepository.addOrderPartnerPairRepository(orderId,partnerId);



    }
    public Order getOrderByIdService(String orderId){
        return orderRepository.getOrderByIdRepository(orderId);

    }
    public DeliveryPartner getPartnerByIdService(String partnerId) {

        return orderRepository.getPartnerByIdRepository(partnerId);
    }
    public Integer getOrderCountByPartnerIdService(String partnerId) {
        return orderRepository.getOrderCountByPartnerIdRepository(partnerId);

    }
    public  List<String> getOrdersByPartnerIdService(String partnerId) {
        return orderRepository.getOrdersByPartnerIdRepository(partnerId);
    }
    public List<String> getAllOrdersService(){

        return orderRepository.getAllOrdersRepository();
    }
    public int getCountOfUnassignedOrdersService(){
        return orderRepository.getCountOfUnassignedOrdersRepository();

    }
    public Integer getOrdersLeftAfterGivenTimeByPartnerIdService(String time,String partnerId){
            return orderRepository.getOrdersLeftAfterGivenTimeByPartnerIdRepository(time,partnerId);
    }
    public String getLastDeliveryTimeByPartnerIdService(String partnerId){
            return orderRepository.getLastDeliveryTimeByPartnerIdRepository(partnerId);
    }
    public void deletePartnerByIdService(String partnerId){
        orderRepository.deletePartnerByIdRepository(partnerId);

    }


    public void deleteOrderByIdService(String orderId){
        orderRepository.deleteOrderByIdRepository(orderId);

    }
}
