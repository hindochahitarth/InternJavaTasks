package org.example.fooddeliverysystem.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice//global exception handler
public class ControllerExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class, MenuItemNotFoundException.class, DeliverPartnerNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        //send json body as return type
        //String mssg=switch (ex) {
          //  case Reso urceNotFoundException r -> r.getMessage();
         //   case MenuItemNotFoundException m -> m.getMessage();
        //    case DeliverPartnerNotFoundException d-> d.getMessage();

       // };
       log.warn("Resource look up  Failed :{} ",ex.getMessage());
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));//for getting sensitive data like IP
    }
    @ExceptionHandler({RestaurantAlreadyExists.class,DeliveryPartnerAlreadyExists.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage restaurantAlreadyExistsException(RestaurantAlreadyExists ex,WebRequest request){
        //String mssg=switch (ex){
         //   case RestaurantAlreadyExists r->"Restaurant Already Exists"+r.getMessage();
         //   case DeliveryPartnerAlreadyExists d->"DeliveryPartner Already Exists"+d.getMessage();
      //  };
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                //mssg,
                request.getDescription(false));

    }
    @ExceptionHandler(RestaurantClosedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage restaurantClosedException(RestaurantClosedException restaurantClosedException,WebRequest request){
        return new ErrorMessage(
                HttpStatus.FORBIDDEN.value(),
                new Date(),
                restaurantClosedException.getMessage(),
                request.getDescription(false)
        );
    }
    @ExceptionHandler(InvalidMenuItemPrice.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage invalidMenuItemPrice(InvalidMenuItemPrice invalidMenuItemPrice,WebRequest request){
        return new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                invalidMenuItemPrice.getMessage(),
                request.getDescription(false)
        );
    }
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage expiredJwtToken(ExpiredJwtException e,WebRequest request){
        log.warn("Invalid JWT Token ");
        return new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                "Your access token has expired. Please log in again to refresh token"+e.getMessage(),
                request.getDescription(false)

        );
    }
    @ExceptionHandler(JwtTokenMissingException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage jwtTokenMissing(
            JwtTokenMissingException e,
            WebRequest request) {

        log.warn("JWT token missing");

        return new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                "Authorization token not found. Please provide a Bearer token.",
                request.getDescription(false)
        );
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage badCredentials(
            BadCredentialsException e,
            WebRequest request) {

        log.warn("Login failed: invalid username or password");

        return new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                "Invalid email or password.",
                request.getDescription(false)
        );
    }
    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage invalidJwtToken(
            JwtException e,
            WebRequest request) {

        log.warn("Invalid JWT token: {}", e.getMessage());

        return new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                new Date(),
                "Invalid or tampered access token. Please login again.",
                request.getDescription(false)
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, List<String>>> invalidUserDetails(MethodArgumentNotValidException e, WebRequest request){
            List<String> errors=e.getBindingResult().getFieldErrors()
                    .stream().map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(getErrorsMap(errors),new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
    private Map<String,List<String>> getErrorsMap(List<String> errors){
        Map<String,List<String>> errorResponse=new HashMap<>();
        errorResponse.put("errors",errors);
        return errorResponse;
    }
}

