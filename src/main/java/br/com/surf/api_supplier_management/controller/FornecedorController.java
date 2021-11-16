package br.com.surf.api_supplier_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surf.api_supplier_management.dto.FornecedoresDto;
import br.com.surf.api_supplier_management.model.Fornecedores;
import br.com.surf.api_supplier_management.repository.FornecedoresRepository;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedoresRepository fornecedoresRepository;
	
	
	@GetMapping
	public List<FornecedoresDto> lista(){
		List<Fornecedores> fornecedores = fornecedoresRepository.findAll();
		return FornecedoresDto.converter(fornecedores);
		
	}
}
