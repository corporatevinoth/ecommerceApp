package com.ecommerce.order.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderRepositoryTest{


    @Autowired
    private OrderRepository orderRepository;

    // JUnit test for saveOrder
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveOrderTest(){

    	com.ecommerce.order.model.Order newOrder = com.ecommerce.order.model.Order.builder()
    			.orderDate(new Date(System.currentTimeMillis()+10000000))
    			.orderId("OD001")
                .orderStatus("PLACED")
                .orderType("DELIVERY")
                .build();

    	orderRepository.save(newOrder);

        Assertions.assertThat(newOrder.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getOrderTest(){
    	com.ecommerce.order.model.Order order=null;
    	try {
    		order = orderRepository.findById(1L).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Assertions.assertThat(order.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfOrdersTest(){

        List<com.ecommerce.order.model.Order> Orders = (List<com.ecommerce.order.model.Order>) orderRepository.findAll();

        Assertions.assertThat(Orders.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateOrderTest(){

    	com.ecommerce.order.model.Order newOrder = ((List<com.ecommerce.order.model.Order>) orderRepository.findByOrderId("OD001")).get(0);

    	newOrder.setOrderStatus("DELIVERED");
    	newOrder.setOrderDate(new Date(System.currentTimeMillis()+10000000));


    	com.ecommerce.order.model.Order OrderUpdated =  orderRepository.save(newOrder);

        Assertions.assertThat(OrderUpdated.getOrderStatus()).isEqualTo("DELIVERED");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteOrderTest(){

    	com.ecommerce.order.model.Order newOrder = orderRepository.findById(1L).get();

        orderRepository.delete(newOrder);

        //orderRepository.deleteById(1L);

        com.ecommerce.order.model.Order order1 = null;

        Optional<com.ecommerce.order.model.Order> optionalOrder = orderRepository.findById(1L);

        if(optionalOrder.isPresent()){
        	order1 = optionalOrder.get();
        }

        Assertions.assertThat(order1).isNull();
    }


	
 }
