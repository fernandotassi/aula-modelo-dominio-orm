package com.napoleao.napo.controladores.manipulador;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.napoleao.napo.dto.ErroCustomizado;
import com.napoleao.napo.services.excecoes.ExcecaoRecursoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorExcecaoControlador
{
	@ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)
	public ResponseEntity<ErroCustomizado> recursoNaoEncontrado(ExcecaoRecursoNaoEncontrado e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroCustomizado erro = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(), 
				                                   request.getRequestURI());
		return ResponseEntity.status(status).body(erro);		
	}
}
