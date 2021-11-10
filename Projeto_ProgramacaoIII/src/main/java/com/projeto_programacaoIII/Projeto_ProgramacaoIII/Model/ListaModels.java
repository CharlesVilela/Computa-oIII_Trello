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
@Table(name="LISTA")
@JsonInclude(Include.NON_EMPTY)
public class ListaModels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name= "ID_QUADRO", referencedColumnName = "ID")
	private QuadroModels quadro;
	
	public ListaModels() {}

	public ListaModels(int id, String nome, QuadroModels quadro) {
		super();
		this.id = id;
		this.nome = nome;
		this.quadro = quadro;
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

	public QuadroModels getQuadro() {
		return quadro;
	}

	public void setQuadro(QuadroModels quadro) {
		this.quadro = quadro;
	}

}
