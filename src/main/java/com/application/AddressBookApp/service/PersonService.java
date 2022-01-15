package com.application.AddressBookApp.service;

import java.util.List;
import java.util.Optional;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.exceptions.PersonException;
import com.application.AddressBookApp.model.*;
import com.application.AddressBookApp.repository.AddressBookRepository;
import com.application.AddressBookApp.repository.PersonRepository;
import com.application.AddressBookApp.utility.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service : Service Layer of Application
 * @Autowired : For Dependency Injection
 */
@Service
public class PersonService implements IPersonService{
    /**
     * AutoWiring for DependencyInjection
     */
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressBookRepository addressBookRepository;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * method to Show all Person Details in AddressBook
     * @return : Entered Person Data
     */
    @Override
    public List<Person> getPersonData(String token) {
    	 if (jwtTokenUtil.isValidToken(token)){
             return personRepository.findAll();
         }
         else throw new AddressBookCustomException("Not Valid Token");
     }

    /**
     * method to return Person Details by ID
     * @param : personID
     * @param : addressBookID
     * @return : Person details of particular ID
     */
    
    @Override
    public Person getPersonDataById(Long personID, String token) {
    	 if (jwtTokenUtil.isValidToken(token)){
             return personRepository.findById(personID).orElseThrow(()-> new AddressBookCustomException("Address Book ID Not Found"));
         }
         else throw new AddressBookCustomException("Not Valid Token");
     }

    /**
     * method to create a Person in Address Book
     * @param : personDTO
     * @param : addressBookID
     * @return : Entered Person Data
     */
    @Override
    public Person createPersonData(Long addressBookID,PersonDTO personDTO) {
        Person personData = new Person(personDTO);
        Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
        if(addressBook.isPresent()){
            personData.setAddressBook(addressBook.get());
        }
        else{
            throw new AddressBookCustomException("Address Book Not Found");
        }
        return personRepository.save(personData);
    }

    /**
     * method to Update Person Data
     * @param : personDTO
     * @param : addressBookID
     * @return : Updated Person Data
     */
    @Override
    public Person updatePersonData(Long addressBookID,Long personID, PersonDTO personDTO , String token) {
        Person personData = this.getPersonDataById(personID, token);
        personData.updatePerson(personDTO);
        Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
        if(addressBook.isPresent()){
            personData.setAddressBook(addressBook.get());
        }
        else{
            throw new AddressBookCustomException("Address Book Not Found");
        }
        return personRepository.save(personData);
    }

    /**
     * method to delete person
     * @param : personID
      * @param : personID
     */
  
	@Override
    public void deletePersonData(Long personID, String token) {
        Person person = this.getPersonDataById(personID, token);
        personRepository.delete(person);
    }
}
