package com.napoleao.napo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="usuario")
@Getter
@Setter
@ToString
public class Usuario implements Serializable
{
	private static final long versionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String fone;
	private LocalDate niver;
	private String password;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Usuario(){}
	public Usuario(Long id, String nome, String email, String fone, LocalDate niver, String password)
	{this.id = id; this.nome = nome; this.email = email; this.fone = fone; this.niver = niver; 
	 this.password = password; this.password = password;}
	
//	public void setId(Long id){this.id = id;}
//	public void setNome(String nome){this.nome = nome;}
//	public void setEmail(String email){this.email = email;}
//	public void setFone(String fone){this.fone = fone;}
//	public void setNiver(LocalDate niver){this.niver = niver;}
//	public void setPassword(String password){this.password = password;}
	
//	public Long getId(){return id;}
//	public String getNome(){return nome;}
//	public String getEmail(){return email;}
//	public String getFone(){return fone;}
//	public LocalDate getNiver(){return niver;}
//	public String getPassword(){return password;}
	
}
