package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.entity.Categories;
import com.java.entity.Contact;
import com.java.entity.Products;
import com.java.repository.CategoriesRepository;
import com.java.repository.ContactRepository;
import com.java.repository.ProductRepository;


@Controller
public class HomeController {

	@GetMapping("/home") /* Decides URL of Web*/
	public String home() {
		return "home"; /* Links to home.html */
	}
	
	@GetMapping("/myorders")
	public String myorders() {
		return "myorders"; 
	}
	
	@GetMapping("/account")
	public String account() {
		return "account"; 
	}

	@GetMapping("/about") 
	public String about() {
		return "about"; 
	}
	
	//contact controls
	@Autowired
	private ContactRepository userRepository;
	
	@GetMapping("/contact")
	public String contactform(Model model) {
		model.addAttribute("user",new Contact()); 
		return "contact";
		}

	
	@PostMapping("/submitForm")
	public String submitForm(@ModelAttribute Contact contact, Model model ) {
		userRepository.saveUser(contact);
		model.addAttribute("message", " ");
		return "home";
	}			
	
	//sellonWeb controls
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/sellProduct")
	public String sellform(Model model) {
		model.addAttribute("product",new Products()); 
		return "sellProduct";
		}

	
	@PostMapping("/submit")
	public String submit(@ModelAttribute Products product, Model model ) {
		productRepository.saveProducts(product);
		model.addAttribute("message", " ");
		return "home";
	}
	
	
	//categories controls	
	@GetMapping("/categories") 
	public String categories() {
		return "index"; /* Links to index.html */
}

	  
	  @GetMapping("/GroceryA")
		public String GroceryA() {
			return "GroceryA";
			
		}
	  
	  @GetMapping("/stationary")
		public String stationary() {
			return "stationary";
			
		}
	  
	  @GetMapping("/fashion")
		public String fashion() {
			return "fashion";
			
		}
	  
	  @GetMapping("/cosmetics")
		public String cosmetics() {
			return "cosmetics";
			
		}
	  
	  @GetMapping("/electronic")
			public String electronic() {
				return "electronic";
				
			}
	  
	  
	  @GetMapping("/medicine")
			public String medicine() {
				return "medicine";
				
			}	
	  

		@Autowired
		private  CategoriesRepository userepository; 
		
	  @GetMapping("/form")  /* New mapping for form page */
	    public String form(Model model) {
		  model.addAttribute("categories", new Categories());
	        return "form"; /* Links to form.html */
	    }
	  
	  
	  @PostMapping("/placeorder")
	  public String placeorder(@ModelAttribute Categories categories,Model model) {
		  userepository.saveOrder(categories);
		  model.addAttribute("message"," ");
		  return "home";
	  }
	
}
