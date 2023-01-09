package com.example.day13workshop.models;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {

    @NotNull(message = "Name cannot be null")
    @Size(min=3, max= 64, message = "Name must be between 3 and 64 chars")
    private String name;

    @Email(message = "Invalid Email address")
    private String email;

    @Min(value =7, message = "Phone number must be at least 7 digit")
    private int phoneNumber;

    private String id;

    @Past(message = "Date of birth must not be future")
    @NotNull(message = "Date of birth is mandatory")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateOfBirth;

    public Contact() {
        this.id = generateId(8);
    }

    public Contact(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = generateId(8);
    }

    public Contact(String name, String email, int phoneNumber, String id, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.dateOfBirth = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    private synchronized String generateId(int numOfChar){
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while(strBuilder.length() < numOfChar){
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numOfChar);
    }
    
}