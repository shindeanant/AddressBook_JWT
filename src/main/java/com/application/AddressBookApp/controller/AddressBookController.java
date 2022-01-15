
package com.application.AddressBookApp.controller;

import java.util.List;
import javax.validation.Valid;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.dto.ResponseDTO;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;
import com.application.AddressBookApp.service.IAddressBookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 * @Valid : Checking Requested bean is valid or not
 */
@RestController
@RequestMapping("/Addressbook")
public class AddressBookController {
    /**
     * AutoWiring AddressBookInterace to Dependency Injection
     */
    @Autowired
    IAddressBookService addressBookService;

    /**
     * API for getting all AddressBook List
     * @return : ResponseEntity of AddressBook List
     */
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAddressBookDetailsDetails(@RequestHeader String token){
        List<AddressBook> addressBooks = addressBookService.getAllAddressBook(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success ", addressBooks, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Getting Address Book by ID
     * @param addressBookID
     * @return : ResponseEntity of AddressBook
     */
    @GetMapping("/getByID/{addressBookID}")
    public ResponseEntity<ResponseDTO> getAddressBookDetailsByID(@PathVariable("addressBookID") Long addressBookID ,@RequestHeader String token){
        AddressBook addressBook = addressBookService.getAddressBookByID(addressBookID,token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success ",addressBook, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Createing Address Book of Person List
     * @param addressBookDTO
     * @return : ResponseEntity of Created AddressBook
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO,@RequestHeader String token){
        AddressBook addressBook = addressBookService.createAddressBook(addressBookDTO,token);
        ResponseDTO responseDTO = new ResponseDTO("Create Call Success ",addressBook, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Updating Address Book Details
     * @param addressBookDTO
     * @param addressBookID
     * @return : ResponseEntity of Updated AddressBook
     */
    @PutMapping("/update/{addressBookID}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO, @PathVariable("addressBookID") Long addressBookID,@RequestHeader String token){
        AddressBook addressBook = addressBookService.updateAddressBookByID(addressBookID,addressBookDTO,token);
        ResponseDTO responseDTO = new ResponseDTO("Update Call Sucess ",addressBook, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API Deleting Address Book ByID
     * @param addressBookID
     * @return : Response Entity of Deleted AddressBook ID
     */
    @DeleteMapping("/deleteByID/{addressBookID}")
    public ResponseEntity<ResponseDTO> deleteAddressBookID(@PathVariable("addressBookID") Long addressBookID,@RequestHeader String token){
        addressBookService.deleteAddressBookByID(addressBookID,token);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Sucess ",addressBookID, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/RegisterUser")
    public ResponseEntity<ResponseDTO> generateUser(@RequestBody User user){
        User userDetailUser = addressBookService.createUser(user);
        ResponseDTO responseDTO = new ResponseDTO("Create Call Success ",userDetailUser, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody User user){
        String userDetailUser = addressBookService.generateToken(user);
        ResponseDTO responseDTO = new ResponseDTO("Create Call Success ",userDetailUser, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);


    }
   
}