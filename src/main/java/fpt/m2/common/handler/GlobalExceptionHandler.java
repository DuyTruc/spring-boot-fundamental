package fpt.m2.common.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fpt.m2.common.constants.MessageConstant;
import fpt.m2.common.exception.BusinessException;
import fpt.m2.common.helpers.HelperBuilder;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<FieldError>  errors = ex.getFieldErrors();
		FieldError err = null;
		List<Map<String,String>> mess = new ArrayList<>();
		Map<String,String> map = null;
		for (int i = 0 ; i < errors.size(); i++) {
			map = new HashMap<>();
			err = errors.get(i);
			String name = (String)err.getField();
			map.put("field",name);
			map.put("message",err.getDefaultMessage());
			mess.add(map);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mess);
	}
	
	@ExceptionHandler({BusinessException.class})
	protected ResponseEntity<?> businessException(BusinessException e) {
		String message = "";
		if (e.getCode() == "0") {
			message = MessageConstant.B2;
		} else if (e.getCode() == "1") {
			message = MessageConstant.B1;
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(HelperBuilder.buildMessage(message));
	}
	
	@ExceptionHandler({Exception.class, RuntimeException.class})
	protected ResponseEntity<?> handlerInternalError(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HelperBuilder.buildMessage(MessageConstant.S1));
	}
}
