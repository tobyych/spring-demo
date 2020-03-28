package com.clover.springdemo.controller;

import com.clover.springdemo.dao.CustomerDAO;
import com.clover.springdemo.entity.Customer;
import com.clover.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> theCustomers = customerService.getCustomers();

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showForForAdd(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
