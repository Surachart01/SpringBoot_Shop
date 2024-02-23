package com.example.project.project_e.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.project.project_e.model.Cart;
import com.example.project.project_e.model.Member;

import java.util.List;


public interface cartRepo extends CrudRepository<Cart,Integer>{
    List<Cart> findByMember(Member member);
}
