package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		productRepo.save(product);
		return "redirect:/products";
	}
	
	@PostMapping("/products/update")
	public String updateProduct(@ModelAttribute("product")Product product) {
		productRepo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/update/{id}")
	public String updateProduct(@PathVariable("id") int id, Model model) {
		String msg="update";
		model.addAttribute("msg", msg);
		Product pd=productRepo.findById(id).get();
		model.addAttribute("product",pd);
		 return "products";
		 }
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model) {
		Product pd=productRepo.findById(id).get();
		productRepo.delete(pd);
		return "redirect:/products";
	}
	
	@GetMapping("/products/add")
	public String addProduct(Model model) {
		String msg="add";
		model.addAttribute("msg", msg);
		 return "products";
		 }
}
