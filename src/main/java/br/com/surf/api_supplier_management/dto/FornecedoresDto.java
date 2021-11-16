package br.com.surf.api_supplier_management.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.surf.api_supplier_management.model.Fornecedores;

public class FornecedoresDto {
	
	private Long id;
	private String fornecedor;
	
	public FornecedoresDto(Fornecedores fornecedores) {
		this.id = fornecedores.getId();
		this.fornecedor = fornecedores.getFornecedor();
	}
	
	public Long getId() {
		return id;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	
	public static List<FornecedoresDto> converter(List<Fornecedores> fornecedores){
		
		return fornecedores.stream().map(FornecedoresDto::new).collect(Collectors.toList());
	}
	
}
