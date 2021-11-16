package br.com.surf.api_supplier_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surf.api_supplier_management.dto.CriticidadeDto;
import br.com.surf.api_supplier_management.model.Criticidade;
import br.com.surf.api_supplier_management.repository.CriticidadeRepository;

@RestController
@RequestMapping("/criticidade")
public class CriticidadeController {
	
	@Autowired
	private CriticidadeRepository criticidadeRepository;
	
	@GetMapping
	
	public List<CriticidadeDto> lista(){
		
		List<Criticidade> criticidade = criticidadeRepository.findAll();
		return CriticidadeDto.converter(criticidade);
	}
	
}
