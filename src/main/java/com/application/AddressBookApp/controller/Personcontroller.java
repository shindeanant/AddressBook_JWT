package com.application.AddressBookApp.controller;

import java.util.List;
import javax.validation.Valid;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.dto.ResponseDTO;
import com.application.AddressBookApp.model.Person;
import com.application.AddressBookApp.service.IPersonService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @RestController : Creating Controller Class
 * @RequestMapping : Mapping Controller Class to URL
 */
@RestController
@RequestMapping("/addressbook")
public class Personcontroller {
    @Autowired
    IPersonService iPersonService;
    
    /**
     * API for getting all Persons in AddressBook
     * @return : ResponseEntity of Pereson
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getContactDetails(@RequestHeader String token){
        List<Person> personData = iPersonService.getPersonData(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success : ", personData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Getting get Person Details by Person ID
     * @param personID
     * @return ResponseEntity of Person Details of given ID
     */
    @GetMapping("/getByID")
    public ResponseEntity<ResponseDTO> getContactByID(@RequestParam Long personID, @RequestHeader String token){
        Person personData = iPersonService.getPersonDataById(personID, token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success : ", personData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        
    }

    /**
     * API for updating Person using Response Entity
     * @param personDTO
     * @return : ResponseEntity of Person data
     */
    @PostMapping("/create/{addressBookID}")
    public ResponseEntity<ResponseDTO> addingContact(@PathVariable("addressBookID") Long addressBookID ,@Valid @RequestBody PersonDTO personDTO, @RequestHeader String token){
        Person personData = iPersonService.createPersonData(addressBookID, personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Call Success : ", personData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Updating Details of Person
     * @param personDTO
     * @return : ResponseEntity of Updated Person
     */
    @PutMapping("/update/{personID}")
    public ResponseEntity<ResponseDTO> updateContact(@RequestParam Long addressBookID ,@Valid @RequestBody PersonDTO contactDTO,@PathVariable("personID") Long personID, @RequestHeader String token){
        Person personData = iPersonService.updatePersonData(addressBookID,personID,contactDTO, token);
        ResponseDTO responseDTO = new ResponseDTO("Update Call Success : ",personData, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * API for Deleteing Person by ID
     * @param personID
     * @return :message showing delete ID
     */
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContactByID(@RequestParam Long personID , @RequestHeader String token){
        iPersonService.deletePersonData(personID, token);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfull : ", personID, HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
