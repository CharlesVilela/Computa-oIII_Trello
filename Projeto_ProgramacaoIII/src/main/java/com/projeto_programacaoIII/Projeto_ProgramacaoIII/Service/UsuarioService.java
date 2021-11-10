package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.UsuarioModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public String Salvar(UsuarioModels usuario) {
		usuarioRepository.save(usuario);
		return "Salvo com Sucesso!";
	}

	public List<UsuarioModels> getAll() {
		List<UsuarioModels> usuarios = new ArrayList<>();
		usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	public UsuarioModels buscarId(int id) {
		UsuarioModels usuario = usuarioRepository.findById(id);
		return usuario;
	}

	public UsuarioModels Update(UsuarioModels newUsuario, int id) {
		UsuarioModels usuario = this.buscarId(id);
		usuario.setUserName(newUsuario.getUserName());
		usuario.setPassword(newUsuario.getPassword());
		usuarioRepository.save(usuario);

		return usuario;
	}

	public String Delete(int id) {
		usuarioRepository.deleteById(id);
		return "Usuario Deletado com Sucesso!";
	}
	
	public UsuarioModels Login(String email, String password) {
		UsuarioModels usuario = usuarioRepository.login(email, password);
		return usuario;
	}

}
