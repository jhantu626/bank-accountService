package io.app.Exceptions;

import io.app.config.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalException {
	@ExceptionHandler(NotFoundException.class)
	public Response handleNotFoundException(Exception ex){
		return new Response(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientBalance.class)
	public Response handleInsufficientBalance(Exception ex){
		return new Response(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
