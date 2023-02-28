package com.vivarepublica.vivastackoverflow.advice;

import com.vivarepublica.vivastackoverflow.domain.response.ErrorResponse;
import com.vivarepublica.vivastackoverflow.exception.BusinessLogicException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) { // @Valid Exception
        return new ResponseEntity<>(ErrorResponse.of(e.getBindingResult()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException e) { // @Validated Exception
        return new ResponseEntity<>(ErrorResponse.of(e.getConstraintViolations()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e) {  // BusinessLogic Exception
        return new ResponseEntity<>(ErrorResponse.of(e.getExceptionCode()),
                HttpStatus.valueOf(e.getExceptionCode().getStatusCode()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) { // 잘 못된 Http 통신일 경우(Method 실수, URL 실수)
        return ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED);
    }


}
