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

    public AddressBookModel getEntryById(int id) {
        Optional<AddressBookModel> entry = addressBookList.stream()
                .filter(model -> model.getId() == id)
                .findFirst();
        return entry.orElse(null);
    }

    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        for (AddressBookModel model : addressBookList) {
            if (model.getId() == id) {
                model.setName(dto.getName());
                model.setAddress(dto.getAddress());
                return model;
            }
        }
        return null;
    }

    public void deleteEntry(int id) {
        addressBookList.removeIf(model -> model.getId() == id);
    }
}
