package com.bridgelabz.address_book_app.controller;

import com.bridgelabz.address_book_app.dto.AddressBookDTO;
import com.bridgelabz.address_book_app.model.AddressBookModel;
import com.bridgelabz.address_book_app.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBookModel> addEntry(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.addEntry(dto));
    }

    @GetMapping("/entries")
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<AddressBookModel> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookModel> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateEntry(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        addressBookService.deleteEntry(id);
        return ResponseEntity.ok("Entry with ID: " + id + " deleted successfully");
    }
}
