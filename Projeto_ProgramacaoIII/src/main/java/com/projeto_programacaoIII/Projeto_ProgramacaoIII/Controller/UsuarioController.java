package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Controller;

import java.util.ArrayList;
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

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.UsuarioModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.UsuarioRepository;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService service;

	public UsuarioController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping("/salvar")
	public String Save(UsuarioModels usuario) {
		try {
			return service.Salvar(usuario);
		} catch (Exception e) {
			return "Error!";
		}
	}

	@GetMapping("/listar")
	public List<UsuarioModels> getAll() { 
		return service.getAll();
	}
	
	@GetMapping("/buscar/{id}")
	public UsuarioModels getBuscar(@PathVariable(value = "id") int id) {
		return service.buscarId(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public UsuarioModels Update(@PathVariable int id, @RequestBody UsuarioModels newUsuario) {
	    return service.Update(newUsuario, id);
	}

	@DeleteMapping("/deletar/{id}")
	public String Delete(@PathVariable(value = "id") Integer id) {
		return service.Delete(id);
	}
	
	@PostMapping("/login")
	public UsuarioModels Login(@RequestBody String email, String password) {
		return service.Login(email, password);
	}

}
