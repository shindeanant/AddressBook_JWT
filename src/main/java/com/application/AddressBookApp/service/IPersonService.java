package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;

public interface IPersonService {
    /**
     * Methods of Service Layer
     */
    public List<Person> getPersonData(String token);
    Person createPersonData(Long addressBookID,PersonDTO personDTO);
    Person updatePersonData(Long addressBookID,Long personID, PersonDTO personDTO, String token);
   
	public Person getPersonDataById(Long personID, String token);
	/**
	 * method to delete person
	 * @param : personID
	  * @param : personID
	 */
	void deletePersonData(Long personID, String token);
}
