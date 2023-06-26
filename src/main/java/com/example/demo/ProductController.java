package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	@GetMapping("/products")
	public String products(Model model) {
		 ArrayList<Product> products=(ArrayList<Product>) productRepo.findAll();
		 model.addAttribute("products", products);
		 return "products";
		 }
	@PostMapping("/products")
	public String addProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		productRepo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/update")
	public String updateProduct(Model model) {
		String msg="update";
		model.addAttribute("msg", msg);
		 return "products";
		 }
	
	@GetMapping("/products/add")
	public String addProduct(Model model) {
		String msg="add";
		model.addAttribute("msg", msg);
		 return "products";
		 }
}
