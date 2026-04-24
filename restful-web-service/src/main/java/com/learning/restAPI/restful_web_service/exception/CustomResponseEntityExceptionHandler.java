package com.learning.restAPI.restful_web_service.exception;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.restAPI.restful_web_service.user.UserNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 * @ExceptionHandler(Exception.class) public final @Nullable
	 * ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest
	 * request){ ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
	 * ex.getMessage(), request.getDescription(false)); ResponseEntity<ErrorDetails>
	 * response=new ResponseEntity<>(errorDetails,
	 * HttpStatus.INTERNAL_SERVER_ERROR); return response; }
	 */
	
	@ExceptionHandler(UserNotFoundException.class)
	public final @Nullable ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false));
		ResponseEntity<ErrorDetails> response=new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@Override
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
				"Total errors:"+ex.getErrorCount()+", First error:"+ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		ResponseEntity<Object> response=new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		return response;
	}
}
