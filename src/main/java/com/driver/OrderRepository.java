package com.driver;



import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class OrderRepository {
    Map<String,Order> map1=new HashMap<>();
    Map<String,DeliveryPartner> map2=new HashMap<>();
    Map<String,List<Order>> map3=new HashMap<>();
    Map<String,Order> unass=new HashMap<>();
    public void addOrderRepository(Order order){
        String k= order.getId();
        map1.put(k,order);
        unass.put(k,order);

    }
    public void addPartnerRepository(String partnerId){
        map2.put(partnerId,new DeliveryPartner(partnerId));
    }
    public void addOrderPartnerPairRepository(String orderId,String partnerId){
       if(map1.containsKey(orderId)&&map2.containsKey(partnerId)){
           if(map3.containsKey(partnerId)){
               map3.get(partnerId).add(map1.get(orderId));
               unass.remove(orderId);
               map2.get(partnerId).setNumberOfOrders(map3.get(partnerId).size());
           }
           else{
               List<Order>list=new ArrayList<>();
               list.add(map1.get(orderId));
               map3.put(partnerId,list);
               unass.remove(orderId);
               map2.get(partnerId).setNumberOfOrders(1);
           }
       }


    }
    public Order getOrderByIdRepository(String orderId){

        Order order= null;
        //order should be returned with an orderId.
        order= map1.get(orderId);

        return order;
    }
    public DeliveryPartner getPartnerByIdRepository(String partnerId) {

        DeliveryPartner deliveryPartner = null;
        deliveryPartner = map2.get(partnerId);
        return deliveryPartner;
    }
    public Integer getOrderCountByPartnerIdRepository(String partnerId) {
            Integer orderCount=0;
       if(map2.containsKey(partnerId)){
           orderCount=map2.get(partnerId).getNumberOfOrders();
       }
        return orderCount;

    }
    public  List<String> getOrdersByPartnerIdRepository(String partnerId) {
        List<String> orders = new ArrayList<>();
        List<Order> list = new ArrayList<>();
        list = map3.get(partnerId);
        for (Order o : list) {
            String a = o.getId();
            orders.add(a);
        }
        return orders;
    }
    public List<String> getAllOrdersRepository(){
        List<String>list=new ArrayList<>();
        for(String s:map1.keySet()){

            list.add(s);
        }
        return list;

    }
    public int getCountOfUnassignedOrdersRepository(){
        return unass.size();

    }
    public Integer getOrdersLeftAfterGivenTimeByPartnerIdRepository(String time,String partnerId){
        String hr=time.substring(0,2);
        String min=time.substring(3,5);

        int totalTime=(Integer.parseInt(hr)*60)+Integer.parseInt(min);
        int count=0;
        for(Order o:map3.get(partnerId)){
            if(o.getDeliveryTime()>totalTime){
                count++;
            }
        }
        return count;
    }
    public String getLastDeliveryTimeByPartnerIdRepository(String partnerId){
        int maxTime=Integer.MIN_VALUE;
        for(Order o:map3.get(partnerId)){
            if(o.getDeliveryTime()>maxTime)
                maxTime=o.getDeliveryTime();
        }
        int hr=maxTime/60;
        int min=maxTime%60;
        String str=hr+":"+min;

        return str;
    }
    public void deletePartnerByIdRepository(String partnerId){
        map2.remove(partnerId);
        List<Order>list=new ArrayList<>();
        list=map3.get(partnerId);
        for(Order o:list){
            unass.put(o.getId(),o);
        }
        map3.remove(partnerId);

    }


    public void deleteOrderByIdRepository(String orderId) {
        map1.remove(orderId);
        for (String s : map3.keySet()) {
            List<Order> list = new ArrayList<>();
            list = map3.get(s);
            Iterator<Order> iterator = list.iterator();
            while (iterator.hasNext()) {
                Order ans = iterator.next();
                if (ans.getId().equals(orderId)) {
                    iterator.remove();
                    map2.get(s).setNumberOfOrders(map3.get(s).size());
                }
            }
            map1.remove(orderId);
        }
    }





}
