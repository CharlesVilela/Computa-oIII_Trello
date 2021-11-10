package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.ListaModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service.ListaService;

@RestController
@RequestMapping("/lista")
public class ListaController {

	@Autowired
	private ListaService listaService;

	public ListaController(ListaService listaService) {
		super();
		this.listaService = listaService;
	}

	@PostMapping("/salvar")
	public String Salvar(ListaModels lista, int id) {
		return listaService.Salvar(lista, id);
	}
	
	@GetMapping("/listar")
	public List<ListaModels> getAll(){
		return listaService.getAll();
	}
	
	@GetMapping("/buscar/{id}")
	public ListaModels buscarId(int id) {
		return listaService.buscarId(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public ListaModels Update(@PathVariable(value = "id") int id, @RequestBody ListaModels newLista) {
		return listaService.Update(newLista, id);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String Delete(@PathVariable(value = "id") int id) {
		return listaService.Delete(id);
	}
	
}
