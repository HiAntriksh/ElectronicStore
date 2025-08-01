package com.lcwd.electronic.store.exceptions;

import com.lcwd.electronic.store.dtos.ApiResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handler resource not found exceotion

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {

        logger.info("Exception Handler invoked !!");


        ApiResponseMessage response = ApiResponseMessage.builder().message(exception.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);

    }

    // MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        Map<String, Object> response = new HashMap<>();
        for (ObjectError objectError : allErrors) {
            String message = objectError.getDefaultMessage();

            // Only cast if it's a FieldError
            if (objectError instanceof FieldError) {
                String field = ((FieldError) objectError).getField();
                response.put(field, message);
            }
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    //  handle bad api exception
    @ExceptionHandler
    public ResponseEntity<ApiResponseMessage> handelBadApiRequest(BadApiRequest exception) {
        logger.info("Bad Api Request !!");
        ApiResponseMessage response = ApiResponseMessage.builder().message(exception.getMessage()).status(HttpStatus.BAD_REQUEST).success(false).build();
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);


    }
}
