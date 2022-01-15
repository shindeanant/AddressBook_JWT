package com.application.AddressBookApp.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * AddressBook DTO Class 
 */
public class AddressBookDTO {

    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Address Book name is Invalid")
    private String addressBookName;

	

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	    
}
