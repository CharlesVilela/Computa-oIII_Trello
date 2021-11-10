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

import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Model.CardModels;
import com.projeto_programacaoIII.Projeto_ProgramacaoIII.Service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

	@Autowired
	private CardService cardService;

	public CardController(CardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	@PostMapping("/salvar")
	public String Salvar(CardModels card, int id) {
		return cardService.Salvar(card, id);
	}
	
	@GetMapping("/listar")
	public List<CardModels> getAll(){
		return cardService.getAll();
	}
	
	@GetMapping("/buscar/{id}")
	public CardModels buscarId(@PathVariable(value="id") int id) {
		return cardService.buscarId(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public CardModels Update(@PathVariable int id, @RequestBody CardModels newCard) {
		return cardService.Update(newCard, id);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String Delete(int id) {
		return cardService.delete(id);
	}

}
