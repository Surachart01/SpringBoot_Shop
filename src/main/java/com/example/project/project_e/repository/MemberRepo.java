package com.example.project.project_e.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.project.project_e.model.Member;
import java.util.List;
import java.util.Optional;



public interface MemberRepo extends CrudRepository<Member,Integer> {
    List<Member> findByRole(String role);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByEmailAndPassword(String email, String password);
    
}
