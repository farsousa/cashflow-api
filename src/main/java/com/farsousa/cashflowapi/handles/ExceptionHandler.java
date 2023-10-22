package com.farsousa.cashflowapi.handles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.farsousa.cashflowapi.dtos.ResponseModel;
import com.farsousa.cashflowapi.exceptions.DadosNaoEncontradosException;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(DadosNaoEncontradosException.class)
	public ResponseEntity<ResponseModel<?>> tratarDadosNaoEncontrados(DadosNaoEncontradosException ex) {		
		String message = ex.getMessage();
		String status = "404 Not Found";
		
		ResponseModel<?> resposta = new ResponseModel<>(message, status, null, null);
		
		return ResponseEntity.status(404).body(resposta);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseModel<?>> tratarValidacaoDto(MethodArgumentNotValidException ex) {		
		String message = ex.getFieldError().getDefaultMessage();
		String status = "400 Bad Request";
		
		ResponseModel<?> resposta = new ResponseModel<>(message, status, null, null);
		
		return ResponseEntity.status(400).body(resposta);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseModel<?>> tratarValidacaoDto(Exception ex) {		
		String message = ex.getMessage();
		String status = "400 Bad Request";
		
		ResponseModel<?> resposta = new ResponseModel<>(message, status, null, null);
		
		return ResponseEntity.status(400).body(resposta);
	}

}
