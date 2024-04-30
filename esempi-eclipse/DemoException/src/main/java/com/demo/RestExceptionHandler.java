package com.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice /* usiamo l'AOP per gestire le eccezioni */
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// questo è il controller che si occupa di gestire le nostre eccezioni
	@ExceptionHandler({DuplicateException.class})
	public final ResponseEntity<ErrorResponse> exceptionDuplicateHandler(Exception ex) {
		ErrorResponse errore = new ErrorResponse();
		errore.setCode(HttpStatus.CONFLICT.value());
		errore.setMessaggio(((DuplicateException)ex).getMessaggio());
		
		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler({NotFoundException.class})
	public final ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception ex) {
		ErrorResponse errore = new ErrorResponse();
		errore.setCode(HttpStatus.NOT_FOUND.value());
		errore.setMessaggio(((DuplicateException)ex).getMessaggio());
		
		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.NOT_FOUND);
	}
}
