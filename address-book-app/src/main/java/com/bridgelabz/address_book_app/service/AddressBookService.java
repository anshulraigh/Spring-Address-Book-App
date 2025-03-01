package com.bridgelabz.address_book_app.service;

import com.bridgelabz.address_book_app.dto.AddressBookDTO;
import com.bridgelabz.address_book_app.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final List<AddressBookModel> addressBookList = new ArrayList<>();
    private int idCounter = 1;

    public AddressBookModel addEntry(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setId(idCounter++);
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        addressBookList.add(model);
        return model;
    }

    public List<AddressBookModel> getAllEntries() {
        return addressBookList;
    }

    public Optional<AddressBookModel> getEntryById(int id) {
        return addressBookList.stream().filter(entry -> entry.getId() == id).findFirst();
    }

    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        for (AddressBookModel entry : addressBookList) {
            if (entry.getId() == id) {
                entry.setName(dto.getName());
                entry.setAddress(dto.getAddress());
                return entry;
            }
        }
        return null;
    }

    public boolean deleteEntry(int id) {
        return addressBookList.removeIf(entry -> entry.getId() == id);
    }
}
