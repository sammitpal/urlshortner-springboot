package com.shortner.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UrlFoundException.class)
	public ResponseEntity<?> handleUrlFoundException(UrlFoundException e){
		ErrorResponse errResp = new ErrorResponse(LocalDateTime.now(),"Slug already exist! Try using a different one",HttpStatus.CONFLICT);
		return new ResponseEntity(errResp,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleUrlFoundException(NotFoundException e){
		ErrorResponse errResp = new ErrorResponse(LocalDateTime.now(),e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
		return new ResponseEntity(errResp,HttpStatus.NOT_FOUND);
	}
	
}
