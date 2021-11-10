package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.CardModels;

public interface CardRepository extends JpaRepository<CardModels, Integer>{

}
