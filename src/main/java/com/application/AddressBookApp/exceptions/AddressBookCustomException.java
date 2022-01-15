package com.application.AddressBookApp.exceptions;
/**
 * Creating Custom Exception Class
 */
public class AddressBookCustomException extends RuntimeException{
    public AddressBookCustomException(String message){
        super(message);
    }
}
