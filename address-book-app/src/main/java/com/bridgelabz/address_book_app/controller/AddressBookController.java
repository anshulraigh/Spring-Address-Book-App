package com.bridgelabz.address_book_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book Application!";
    }
}
