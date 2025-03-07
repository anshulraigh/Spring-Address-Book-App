package com.bridgelabz.address_book_app.model;

import jakarta.persistence.*; // Ensure JPA annotations are imported
import lombok.Data;

@Entity
@Table(name = "address_book")
@Data
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
}
