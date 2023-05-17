package com.codewithrajan.blogapiapp.config;


import com.codewithrajan.blogapiapp.exceptions.ApiException;
import com.codewithrajan.blogapiapp.exceptions.ResourceNotFoundException;
import com.codewithrajan.blogapiapp.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exc){
		String messageString = exc.getMessage();
		ApiResponse apiResponse = new ApiResponse(messageString,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> handleApiException(ApiException exc){
		String messageString = exc.getMessage();
		ApiResponse apiResponse = new ApiResponse(messageString,true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exc){
		
		Map<String, String> respMap = new HashMap<>();
		
		exc.getBindingResult().getAllErrors().forEach((err) -> {
			String fieldName = ((FieldError) err).getField();
			String messageString = err.getDefaultMessage();
			respMap.put(fieldName, messageString);
		});
		return new ResponseEntity<Map<String,String>>(respMap,HttpStatus.BAD_REQUEST);
	}
	
}
