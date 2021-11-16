package br.com.surf.api_supplier_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surf.api_supplier_management.dto.CatalogoAberturaDto;
import br.com.surf.api_supplier_management.model.CatalogoAbertura;
import br.com.surf.api_supplier_management.repository.CatalogoAberturaRepository;

@RestController
@RequestMapping("/catalogoAbertura")
public class CatalogoAberturaController {
	
	@Autowired
	private CatalogoAberturaRepository catalogoAberturaRepository;
	
	
	@GetMapping
	public List<CatalogoAberturaDto> lista(){
		List<CatalogoAbertura> catalogoAbertura = catalogoAberturaRepository.findAll();
		
		return CatalogoAberturaDto.converter(catalogoAbertura);
		
	}
	
}
