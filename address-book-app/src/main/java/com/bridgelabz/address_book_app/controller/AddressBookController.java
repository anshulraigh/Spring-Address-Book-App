package com.bridgelabz.address_book_app.controller;

import com.bridgelabz.address_book_app.dto.AddressBookDTO;
import com.bridgelabz.address_book_app.model.AddressBookModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("GET Request Received");
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<String> getMessageById(@PathVariable int id) {
        return ResponseEntity.ok("GET Request Received for ID: " + id);
    }

    @PostMapping("/message")
    public ResponseEntity<String> createMessage() {
        return ResponseEntity.ok("POST Request Received");
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<String> updateMessage(@PathVariable int id) {
        return ResponseEntity.ok("PUT Request Received for ID: " + id);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable int id) {
        return ResponseEntity.ok("DELETE Request Received for ID: " + id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBookModel> addEntry(@RequestBody AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setId(1);
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        return ResponseEntity.ok(model);
    }
}