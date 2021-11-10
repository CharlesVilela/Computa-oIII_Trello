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
@Table(name="CARD")
@JsonInclude(Include.NON_EMPTY)
public class CardModels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String nome;
	
	@Column(name="DESCRIPTION")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name= "ID_LISTA", referencedColumnName = "ID")
	private ListaModels lista;
	
	
	public CardModels() {}


	public CardModels(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public ListaModels getLista() {
		return lista;
	}


	public void setLista(ListaModels lista) {
		this.lista = lista;
	}
	
	
	

}
