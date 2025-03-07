package com.bridgelabz.address_book_app.service;

import com.bridgelabz.address_book_app.dto.AddressBookDTO;
import com.bridgelabz.address_book_app.model.AddressBookModel;
import com.bridgelabz.address_book_app.repository.AddressBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final AddressBookRepository addressBookRepository;

    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    // ✅ Save data to MySQL instead of memory
    public AddressBookModel addEntry(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setZipcode(dto.getZipcode());
        model.setPhoneNumber(dto.getPhoneNumber());
        return addressBookRepository.save(model);  // ✅ Save to database
    }

    // ✅ Fetch all data from MySQL
    public List<AddressBookModel> getAllEntries() {
        return addressBookRepository.findAll();
    }

    // ✅ Fetch entry by ID from MySQL
    public Optional<AddressBookModel> getEntryById(int id) {
        return addressBookRepository.findById(id);
    }

    // ✅ Update entry in MySQL
    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        Optional<AddressBookModel> optionalModel = addressBookRepository.findById(id);
        if (optionalModel.isPresent()) {
            AddressBookModel model = optionalModel.get();
            model.setName(dto.getName());
            model.setAddress(dto.getAddress());
            model.setCity(dto.getCity());
            model.setState(dto.getState());
            model.setZipcode(dto.getZipcode());
            model.setPhoneNumber(dto.getPhoneNumber());
            return addressBookRepository.save(model);  // ✅ Save changes to database
        }
        return null;
    }

    // ✅ Delete entry from MySQL
    public boolean deleteEntry(int id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
