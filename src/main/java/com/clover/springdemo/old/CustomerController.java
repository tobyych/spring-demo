package com.clover.springdemo.old;

import com.clover.springdemo.entity.OldCustomer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("showForm")
    public String showForm(Model theModel) {
        OldCustomer theCustomer = new OldCustomer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }


    @RequestMapping("processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") OldCustomer theCustomer,
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
