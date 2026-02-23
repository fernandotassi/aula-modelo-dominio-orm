
package com.napoleao.napo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable
{
	private static final long versionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String email;
	private String fone;
	private LocalDate niver;
	private String senha;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Usuario(){}
	public Usuario(Long id, String nome, String email, String fone, LocalDate niver, String senha)
	{this.id = id; this.nome = nome; this.email = email; this.fone = fone; this.niver = niver; 
	 this.senha = senha;}
	
	public void setId(Long id){this.id = id;}
	public void setNome(String nome){this.nome = nome;}
	public void setEmail(String email){this.email = email;}
	public void setFone(String fone){this.fone = fone;}
	public void setNiver(LocalDate niver){this.niver = niver;}
	public void setSenha(String senha){this.senha = senha;}
	
	public Long getId(){return id;}
	public String getNome(){return nome;}
	public String getEmail(){return email;}
	public String getFone(){return fone;}
	public LocalDate getNiver(){return niver;}
	public String getSenha(){return senha;}
	
	@Override
	public int hashCode(){return Objects.hash(id);}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}		
}
