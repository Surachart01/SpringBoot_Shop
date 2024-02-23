package com.example.project.project_e.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.project_e.model.Cart;
import com.example.project.project_e.model.Member;
import com.example.project.project_e.model.Product;
import com.example.project.project_e.repository.MemberRepo;
import com.example.project.project_e.repository.cartRepo;
import com.example.project.project_e.repository.productRepo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@RestController
@RequestMapping("/cart")
public class cartController {
    @Autowired
    private cartRepo cartRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private productRepo productRepo;


    @GetMapping("{memberId}")
    public Iterable<Cart> getByMemberId(@PathVariable int memberId) {
        return cartRepo.findByMember(null);
    }
    
    @Getter @Setter @NoArgsConstructor
    public static class requestCart{
        private int productId;
        private int qty;
    }

    @PostMapping("{memberId}")
    public ResponseEntity<Cart> create(@PathVariable int memberId,@RequestBody requestCart reCart) {

        Optional<Member> dataMember = memberRepo.findById(memberId);
        Optional<Product> dataProduct = productRepo.findById(reCart.getProductId());
        Cart cart = new Cart();

        Member member = dataMember.get();
        Product product = dataProduct.get();
        cart.setMember(member);
        cart.setProduct(product);

        Cart newCart = cartRepo.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
    }



    @SuppressWarnings("null")
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable int id) {
        // carRepository.deleteById(id);
        // return ResponseEntity.ok("Delete data complate");

        Optional<Cart> optionalCart = cartRepo.findById(id);
        Map<String, String> responseMap = new HashMap<>();

        if (optionalCart.isPresent()) {
            // has data
            cartRepo.delete(optionalCart.get());
            responseMap.put("message", "Delete data complete");
        } else {
            responseMap.put("message", "Cannot find car id " + id);
        }
        ResponseEntity<Map<String, String>> response = ResponseEntity.ok(responseMap);

        return response;
    }



}
