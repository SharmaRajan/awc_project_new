package com.dalmia.dalmia.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dalmia.dalmia.header.Header;
import com.dalmia.dalmia.responses.ErrorResponse;
import com.dalmia.dalmia.responses.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CompanyNotFound.class)
	public ErrorResponse noUser(CompanyNotFound noUser) {

		return new ErrorResponse(noUser.getHeader());
	}
	
	
	@ExceptionHandler(IndrustrySectorNotFound.class)
	public ErrorResponse noUser(IndrustrySectorNotFound noUser) {

		return new ErrorResponse(noUser.getHeader());
	}

	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methododArgNotFoundException(MethodArgumentNotValidException e) {

		
		Map<String, String> map = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(objectError -> {
			String field = ((FieldError) objectError).getField();
			String defaultMessage = objectError.getDefaultMessage();
			map.put(field, defaultMessage);
		});
//
//		ErrorResponse errorResponse = new ErrorResponse(map);
//		Header header = new Header(HttpStatus.BAD_REQUEST,"Validation Fail");
//		errorResponse.setHeader(header);
		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

}
