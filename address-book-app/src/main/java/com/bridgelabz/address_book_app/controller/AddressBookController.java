package com.bridgelabz.address_book_app.controller;

import com.bridgelabz.address_book_app.dto.AddressBookDTO;
import com.bridgelabz.address_book_app.model.AddressBookModel;
import com.bridgelabz.address_book_app.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookModel>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressBookModel>> getEntryById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getEntryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateEntry(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(addressBookService.updateEntry(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEntry(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.deleteEntry(id));
    }
}
