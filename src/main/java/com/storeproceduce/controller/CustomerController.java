package com.storeproceduce.controller;

import com.storeproceduce.model.Customer;
import com.storeproceduce.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/create")
    public String showForm(Model model){
      model.addAttribute("customer", new Customer());
      return "/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("customer") Customer customer, Model model){
        customerService.savePro(customer);
        return "/create";
    }
}
