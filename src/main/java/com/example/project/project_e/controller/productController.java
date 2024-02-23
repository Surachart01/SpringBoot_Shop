package com.example.project.project_e.controller;


import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.project_e.model.Product;
import com.example.project.project_e.repository.productRepo;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private productRepo pRepo;

    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity<Iterable> getAll() {
        Iterable data = pRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        @SuppressWarnings("null")
        Product newProduct = pRepo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

     @PutMapping("/edit/{id}")
    public ResponseEntity<Map<String, Object>> editProduct(@PathVariable int id, @RequestBody Product product) {
        Optional<Product> data = pRepo.findById(id);
        Map<String, Object> responseMap = new HashMap<>();
        if (data.isPresent()) {
            Product oldProduct = data.get();
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());

            pRepo.save(oldProduct);
            responseMap.put("message", "Edit product id " + id + " complate");
            responseMap.put("data", oldProduct);

        } else {
            responseMap.put("message", "Cannot find product id " + id);
        }
         ResponseEntity<Map<String, Object>> res = ResponseEntity.ok(responseMap);
         return res; 

         
    }

    @SuppressWarnings("null")
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable int id) {
        // carRepository.deleteById(id);
        // return ResponseEntity.ok("Delete data complate");

        Optional<Product> optionalProduct = pRepo.findById(id);
        Map<String, String> responseMap = new HashMap<>();

        if (optionalProduct.isPresent()) {
            // has data
            pRepo.delete(optionalProduct.get());
            responseMap.put("message", "Delete data complete");
        } else {
            responseMap.put("message", "Cannot find product id " + id);
        }
        ResponseEntity<Map<String, String>> response = ResponseEntity.ok(responseMap);

        return response;
    }


}
