package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.QuadroModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.UsuarioRepository;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service.QuadroService;

@RestController
@RequestMapping("/quadro")
public class QuadroController {

	@Autowired
	private QuadroService quadroService;
	
	
	
	public QuadroController(QuadroService quadroService) {
		super();
		this.quadroService = quadroService;
	}

	@PostMapping("/salvar")
	public String Save(QuadroModels quadro, int id) {
		return quadroService.Salvar(quadro, id);
	}
	
	@GetMapping("/listar")
	public List<QuadroModels> getAll(){
		return quadroService.getAll();
	}
	
	@GetMapping("/buscar/{id}")
	public QuadroModels buscarId(@PathVariable(value = "id") int id) {
		return quadroService.buscarId(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public QuadroModels Update(@PathVariable int id, @RequestBody QuadroModels newQuadro) {
		return quadroService.Update(newQuadro, id);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String Delete(@PathVariable(value="id") Integer id) {
		return quadroService.Delete(id);
	}

}
