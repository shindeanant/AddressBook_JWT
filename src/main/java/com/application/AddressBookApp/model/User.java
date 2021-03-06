package com.application.AddressBookApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_list")

public class User {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String userName;
    private String passWord;
	public User(Long id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
    
    
    
}
