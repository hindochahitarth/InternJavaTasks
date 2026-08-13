package org.example.fooddeliverysystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.lang.module.ResolutionException;
import java.util.Date;


@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler(ResolutionException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

       log.warn("Resource look up  Failed :{} ",ex.getMessage());
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RestaurantAlreadyExists.class)
    public ResponseEntity<ErrorMessage> restaurantAlreadyExistsException(RestaurantAlreadyExists restaurantAlreadyExists,WebRequest request){
        ErrorMessage message=new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                new Date(),
                restaurantAlreadyExists.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(message,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(RestaurantClosedException.class)
    public ResponseEntity<ErrorMessage> restaurantClosedException(RestaurantClosedException restaurantClosedException,WebRequest request){
        ErrorMessage message=new ErrorMessage(
                HttpStatus.FORBIDDEN.value(),
                new Date(),
                restaurantClosedException.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorMessage>(message,HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(InvalidMenuItemPrice.class)
    public ResponseEntity<ErrorMessage> invalidMenuItemPrice(InvalidMenuItemPrice invalidMenuItemPrice,WebRequest request){
        ErrorMessage errorMessage=new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                invalidMenuItemPrice.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
    }


}

