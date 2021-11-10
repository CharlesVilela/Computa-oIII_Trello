package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.UsuarioModels;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModels, Integer>{

	UsuarioModels findById(int id);

	@Query(value = "select * from USUARIO where EMAIL = ':email' and PASSWORD = ':password' ", nativeQuery = true)
	UsuarioModels login(String email, String password);
	
}
