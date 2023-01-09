package com.example.day13workshop.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.day13workshop.models.Contact;
import com.example.day13workshop.util.Contacts;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path="/addressbook")
public class AddressbookController {

    @Autowired
    Contacts ctcz;

    @Autowired
    ApplicationArguments appArgs;

    private static final String DEFAULT_DATADIR="/Users/bindm/src/day13-workshop";

    @GetMapping
    public String showAddrBookForm(Model model){
        model.addAttribute("contact", new Contact());
        return "addressbook";
    }

    @PostMapping
    public String saveContact(@Valid Contact contact, BindingResult bindingResult, Model model) throws IOException{
        if(bindingResult.hasErrors())
            return "addressbook";
            if(!checkAgeInBetween(contact.getDateOfBirth())){
                ObjectError err = new ObjectError("dateOfBirth", "Age must be between 10 to 100");
                bindingResult.addError(err);
                return "addressbook";
            }
            ctcz.saveContact(contact, model, appArgs, DEFAULT_DATADIR);
        return"result";
    }

    private boolean checkAgeInBetween(LocalDate dob){
        int calculatedAge = 0;
        if(null != dob){
            calculatedAge = Period.between(dob, LocalDate.now()).getYears();
        }

        if(calculatedAge >= 10 && calculatedAge <=100){
            return true;
        }

        return false;
    }
}