package com.napoleao.napo.controladores.manipulador;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.napoleao.napo.dto.CampoMensagem;
import com.napoleao.napo.dto.ErroCustomizado;
import com.napoleao.napo.dto.ErroValidado;
import com.napoleao.napo.services.excecoes.ExcecaoBancoDados;
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
	
	@ExceptionHandler(ExcecaoBancoDados.class)
	public ResponseEntity<ErroCustomizado> bancoDados(ExcecaoBancoDados e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.CONFLICT;
		ErroCustomizado erro = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(), 
				                                   request.getRequestURI());
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroCustomizado> naoValidou(MethodArgumentNotValidException e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.PRECONDITION_FAILED;
		ErroValidado erro = new ErroValidado(Instant.now(), status.value(), "dados inválidos", 
				                                   request.getRequestURI());
				                                		   
		for(FieldError f : e.getBindingResult().getFieldErrors())
			{erro.adicionaErro(f.getField(), f.getDefaultMessage());}
			
		return ResponseEntity.status(status).body(erro);		
	}
}
