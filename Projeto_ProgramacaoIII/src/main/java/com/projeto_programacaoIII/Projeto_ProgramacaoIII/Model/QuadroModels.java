package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="QUADRO")
@JsonInclude(Include.NON_EMPTY)
public class QuadroModels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="name")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name= "ID_USUARIO", referencedColumnName = "ID")
	private UsuarioModels usuario;
	
	public QuadroModels() {}

	public QuadroModels(String nome, UsuarioModels usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public UsuarioModels getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModels usuario) {
		this.usuario = usuario;
	}
	
}
