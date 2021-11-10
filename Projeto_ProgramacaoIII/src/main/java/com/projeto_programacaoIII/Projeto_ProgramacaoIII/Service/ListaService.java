package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.ListaModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.QuadroModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.ListaRepository;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.QuadroRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;
	
	@Autowired
	private QuadroRepository quadroRepository;
	

	public ListaService(ListaRepository listaRepository, QuadroRepository quadroRepository) {
		super();
		this.listaRepository = listaRepository;
		this.quadroRepository = quadroRepository;
	}

	public String Salvar(ListaModels lista, int id) {
		
		QuadroModels quadro = quadroRepository.getById(id);
		lista.setQuadro(quadro);
		listaRepository.save(lista);
		return "Salvo com Sucesso!";
	}
	
	public List<ListaModels> getAll(){
		List<ListaModels> lista = new ArrayList<>();
		lista = listaRepository.findAll();
		return lista;
	}
	
	public ListaModels buscarId(int id) {
		ListaModels lista = listaRepository.getById(id);
		return lista;
	}
	
	public ListaModels Update(ListaModels newLista, int id) {
		ListaModels lista = this.buscarId(id);
		lista.setNome(newLista.getNome());
		listaRepository.save(lista);
		
		return lista;
	}
	
	public String Delete(int id) {
		listaRepository.deleteById(id);
		return "Lista Deletado com Sucesso!";
	}

}
