package com.application.AddressBookApp.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import com.application.AddressBookApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice : Creating Controller Advice to Handle Exceptions
 * @ExceptionHandler : Creating Exception Handler method to handle Exceptions Thrown
 */
@ControllerAdvice
public class AddressBookException {
    private static final String message = " Exception while processing REST Request";

    /**
     * Method to handle MethodArgumentNotValidException is thrown 
     * @param methodArgumentNotValidException
     * @return : ResponseEntity of ResponseDTO object of exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr->objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message,errMsg, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method to handle custom AddressBookCustomException is Thrown
     * @param addressBookCustomException
     * @return : ResponseEntity of ResponseDTO object of Custom exception
     */
    @ExceptionHandler(AddressBookCustomException.class)
    public ResponseEntity<ResponseDTO> handlerAddressBookCustomException(AddressBookCustomException addressBookCustomException){
        ResponseDTO responseDTO = new ResponseDTO(message,addressBookCustomException.getMessage(),HttpStatus.BAD_REQUEST );
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
