package com.application.AddressBookApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.application.AddressBookApp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 * @Id : To Describe value as a Id in MySQL
 * @GenerateValue : To auto generate id value
 * @Column : To make that variable as a column
 * @Entity : To create class as entity
 * @Table : to Create table
 * @Data : To Auto Generated Getters and Setters
 * @NoArgsConstructor : Generating No Argument Constructor using Lombok
 * @OneToMany : Creating one to many relationship
 * @JoinColumn : Joining Column using Foreign Key
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "address_book_list")
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_Book_ID")
    private Long addressBookID;

    private String addressBookName;


    /**
     * Defining custom Constructor 
     * @param addressBookDTO
    */
    public AddressBook(AddressBookDTO addressBookDTO){
        this.updateAddressBook(addressBookDTO);
    }

    /**
     * Creating Method to define varaiables of modal class
     * @param addressBookDTO
    */
    public void updateAddressBook(AddressBookDTO addressBookDTO){
        this.addressBookName = addressBookDTO.getAddressBookName();
    }
}