package br.com.surf.api_supplier_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surf.api_supplier_management.dto.CatalogoSolucaoDto;
import br.com.surf.api_supplier_management.model.CatalogoSolucao;
import br.com.surf.api_supplier_management.repository.CatalogoSolucaoRepository;

@RestController
@RequestMapping("/catalogoSolucao")
public class CatalogoSolucaoController {
	
	@Autowired
	private CatalogoSolucaoRepository catalogoSolucaoRepository;
	
	@GetMapping
	public List<CatalogoSolucaoDto> lista(){
		
		List<CatalogoSolucao> catalogoSolucao = catalogoSolucaoRepository.findAll();
		return CatalogoSolucaoDto.converter(catalogoSolucao);
	}
	
}
