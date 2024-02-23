package com.example.project.project_e.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.project.project_e.model.Order;
import com.example.project.project_e.model.Order_Detail;
import java.util.List;


public interface order_detailRepo extends CrudRepository<Order_Detail,Integer>{

    List<Order_Detail> findByOrder(Order order);
}
