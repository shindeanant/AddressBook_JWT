package com.application.AddressBookApp.model;

import com.application.AddressBookApp.dto.PersonDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To generate Getters and Setters
 * @NoArgsConstructor : To Generate No Argument Constructor.
 * @Entity : To Create Entity i.e Table
 * @Table : To Declare Entity as a Table and Setting Name
 * @Id : Creating Id in Table
 * @GeneratedValue : To Auto Generated Id
 * @Column : Declaring varible name as a Column Name
 * @ManyToOne : Mapping person_list table to addressBookTable using Foreign Key
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "person_list")
public class Person {

    /**
     * Variables of the class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_ID")
    private Long personID;
    @Column(name = "first_Name")
    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private String city;
    private String state;
    private String country;
    private String address;
    private String profilePic;

    @ManyToOne
    @JoinColumn(name = "fk_address_Book_ID",referencedColumnName = "address_Book_ID")
    private AddressBook addressBook;

    /**
     * Defining Constructor
     * @param personDTO
     */
    public Person(PersonDTO personDTO){
        this.updatePerson(personDTO);
    }
    
    /**
     * Method to define variables of class
     */
    public void updatePerson(PersonDTO personDTO){
        this.firstName=personDTO.getFirstName();
        this.lastName=personDTO.getLastName();
        this.gender = personDTO.getGender();
        this.mobileNo=personDTO.getMobileNo();
        this.emailAddress=personDTO.getEmailAddress();
        this.city=personDTO.getCity();
        this.state=personDTO.getState();
        this.country=personDTO.getCountry();
        this.address=personDTO.getAddress();
        this.profilePic=personDTO.getProfilePic();

    }
}