package br.com.surf.api_supplier_management.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.surf.api_supplier_management.model.Criticidade;

public class CriticidadeDto {

	private Long id;
	private String criticidade;

	public CriticidadeDto(Criticidade criticidade) {
		this.id = criticidade.getId();
		this.criticidade = criticidade.getCriticidade();
	}
	
	public Long getId() {
		return id;
	}

	public String getCriticidade() {
		return criticidade;
	}
	
	public static List<CriticidadeDto> converter(List<Criticidade> criticidade){
		
		return criticidade.stream().map(CriticidadeDto::new).collect(Collectors.toList());
		
	}
	
}
