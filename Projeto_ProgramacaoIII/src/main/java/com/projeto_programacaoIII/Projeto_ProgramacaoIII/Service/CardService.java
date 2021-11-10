package com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.CardModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.ListaModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.CardRepository;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Repository.ListaRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ListaRepository listaRepository;

	public CardService(CardRepository cardRepository) {
		super();
		this.cardRepository = cardRepository;
	}
	
	
	public String Salvar(CardModels card, int id) {
		ListaModels lista = listaRepository.getById(id);
		card.setLista(lista);
		cardRepository.save(card);
		
		return "Card Salvo com Sucesso!";
	}
	
	public List<CardModels> getAll() {
		List<CardModels> cards = new ArrayList<>(); 
		cards = cardRepository.findAll();
		
		return cards;
	}
	
	public CardModels buscarId(int id) {
		CardModels card = cardRepository.getById(id);
		return card;
	}
	
	public CardModels Update(CardModels newCard, int id) {
		CardModels card = this.buscarId(id);
		card.setNome(newCard.getNome());
		card.setDescricao(newCard.getDescricao());
		cardRepository.save(card);
		
		return card;
	}
	
	public String delete(int id) {
		cardRepository.deleteById(id);
		return "Deletado com Sucesso!";
	}

}
