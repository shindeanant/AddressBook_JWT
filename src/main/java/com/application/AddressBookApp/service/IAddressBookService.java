package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;

/**
 * Service Layer Interface
 */
public interface IAddressBookService {
    /**
     * Creating Methods to Perform CURD operation
     */
    public List<AddressBook> getAllAddressBook(String token);
    public AddressBook getAddressBookByID(Long addressBookID,String token);
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO,String token);
    public AddressBook updateAddressBookByID(Long addressBookID,AddressBookDTO addressBookDTO,String token);
    public void deleteAddressBookByID(Long addressBookID,String token);

    public User createUser(User user);

    public String generateToken(User user);
}
