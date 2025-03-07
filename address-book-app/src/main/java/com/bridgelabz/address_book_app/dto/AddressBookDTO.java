package com.bridgelabz.address_book_app.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
}
