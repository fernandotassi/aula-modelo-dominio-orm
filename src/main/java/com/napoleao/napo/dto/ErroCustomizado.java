package com.napoleao.napo.dto;

import java.time.Instant;

public class ErroCustomizado 
{
	  private Instant timestamp;
	  private Integer status;
	  private String erro;
 	  private String path;
	  
 	  public ErroCustomizado(Instant timestamp, Integer status, String erro, String path) 
	  {this.timestamp = timestamp; this.status = status; this.erro = erro; this.path = path;}

	  public Instant getTimestamp(){return timestamp;}
	  public Integer getStatus(){return status;}
	  public String getErro(){return erro;}
	  public String getPath(){return path;}	  
}
