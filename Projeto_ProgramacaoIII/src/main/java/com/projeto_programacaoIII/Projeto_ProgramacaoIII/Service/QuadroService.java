package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.QuadroModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.UsuarioModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.QuadroRepository;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.UsuarioRepository;

@Service
public class QuadroService {

	@Autowired
	private QuadroRepository quadroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public QuadroService(QuadroRepository quadroRepository, UsuarioRepository usuarioRepository) {
		super();
		this.quadroRepository = quadroRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public String Salvar(QuadroModels quadro, int id) {
		UsuarioModels usuario = usuarioRepository.findById(id);
		quadro.setUsuario(usuario);
		quadroRepository.save(quadro);
		
		return "Quadro Cadastrado com Sucesso!";
	}
	
	public List<QuadroModels> getAll(){
		List<QuadroModels> quadros = new ArrayList<>();
		quadros = quadroRepository.findAll();
		return quadros;
	}
	
	public QuadroModels buscarId(int id) {
		QuadroModels quadro = quadroRepository.getById(id);
		return quadro;
	}
	
	public QuadroModels Update(QuadroModels newQuadro, int id) {
		QuadroModels quadro = this.buscarId(id);
		quadro.setNome(newQuadro.getNome());
		quadroRepository.save(quadro);
		
		return quadro;
	}
	
	public String Delete(int id) {
		quadroRepository.deleteById(id);
		return "Quadro Deletado com Sucesso!";
	}

}
