package com.coding.springrest.rest;

import com.coding.springrest.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// controller advice used for global exception handling
/*@ControllerAdvice is a specialization of the@Component annotation which allows to handle exceptions across
the whole application in one global handling component.It can be viewed as an interceptor of exceptions
thrown by methods annotated with@RequestMapping and similar.*/

@ControllerAdvice
public class StudentRestExceptionHandler {

    // Add an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    // add another exception handler to catch any exception - catch all
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
