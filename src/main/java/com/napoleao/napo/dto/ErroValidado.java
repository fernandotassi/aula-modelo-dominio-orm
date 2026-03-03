package com.napoleao.napo.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErroValidado extends ErroCustomizado
{
	private List<CampoMensagem> erros = new ArrayList<>();

	public ErroValidado(Instant timestamp, Integer status, String erro, String path) 
	{super(timestamp, status, erro, path);}
	
	public List<CampoMensagem> getErros(){return erros;}
	
	public void adicionaErro(String nome, String mensagem)
	{erros.add(new CampoMensagem(nome, mensagem));}	
}
