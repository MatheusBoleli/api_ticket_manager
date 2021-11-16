package br.com.surf.api_supplier_management.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.surf.api_supplier_management.model.CatalogoSolucao;

public class CatalogoSolucaoDto {

	private Long id;
	private String solucao;
	
	public CatalogoSolucaoDto(CatalogoSolucao catalogoSolucao) {
		this.id = catalogoSolucao.getId();
		this.solucao = catalogoSolucao.getSolucao();
	}
	

	public Long getId() {
		return id;
	}
	public String getSolucao() {
		return solucao;
	}
	
	public static List<CatalogoSolucaoDto> converter(List<CatalogoSolucao> catalogoSolucao){
		
		return catalogoSolucao.stream().map(CatalogoSolucaoDto::new).collect(Collectors.toList());
	}
	
}
