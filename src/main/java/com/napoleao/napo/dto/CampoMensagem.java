package com.napoleao.napo.dto;

public class CampoMensagem 
{
	private String nome;
	private String mensagem;
	
	public CampoMensagem(){}
	
	public CampoMensagem(String nome, String mensagem)
	{this.nome = nome; this.mensagem = mensagem;}
	
	public String getNome(){return nome;}
	public String getMensagem(){return mensagem;}
 }
