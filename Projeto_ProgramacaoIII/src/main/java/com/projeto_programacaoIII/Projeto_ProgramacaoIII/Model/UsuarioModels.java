package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="USUARIO")
@JsonInclude(Include.NON_EMPTY)
public class UsuarioModels implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotBlank(message = "USERNAME IS REQUIRED")
	@Column(name = "USERNAME")
	private String userName;
	
	@NotBlank(message = "E-MAIL IS REQUIRED")
	@Email(message = "E-MAIL NOT VALID")
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "PASSWORD IS REQUIRED")
	@Column(name = "PASSWORD", nullable = false, length = 8)
	private String password;
	
	public UsuarioModels() {}
	
	public UsuarioModels(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
