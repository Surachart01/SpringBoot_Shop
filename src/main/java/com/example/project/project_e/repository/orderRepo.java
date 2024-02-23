package com.example.project.project_e.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.project.project_e.model.Order;

public interface orderRepo extends CrudRepository<Order,Integer>{
    
}
