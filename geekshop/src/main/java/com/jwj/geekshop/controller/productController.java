package com.jwj.geekshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jwj.geekshop.repository.productRepository;
import com.jwj.geekshop.model.product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class productController {

    @Autowired
    private productRepository proRepository;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        Iterable<product> product_ = proRepository.findAll();
        model.addAttribute("products", product_);
        return "catalog";
    }
    @GetMapping("/catalog/add")
    public String catalogAdd(Model model) {
        return "catalogAdd";
    }

    @PostMapping("/catalog/add")
    public String catalogProductAdd(@RequestParam String title, @RequestParam String description, @RequestParam String price, Model model){
        product product_1 = new product(title, description, price);
        proRepository.save(product_1);
        return "redirect:/catalog";
    }

    @GetMapping("/catalog/{id}")
    public String productDetails(@PathVariable(value = "id") long id, Model model){
        if(!proRepository.existsById(id)){
            return "redirect:/catalog";
        }

        Optional<product> post = proRepository.findById(id);
        ArrayList<product> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("products", res);
        return "productDetails";
    }
}
