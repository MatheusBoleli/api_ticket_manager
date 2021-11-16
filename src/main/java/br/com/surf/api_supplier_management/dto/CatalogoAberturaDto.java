package br.com.surf.api_supplier_management.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.surf.api_supplier_management.model.CatalogoAbertura;

public class CatalogoAberturaDto {
	
	private Long id;
	private String categoria;
	
	public CatalogoAberturaDto(CatalogoAbertura catalogoAbertura) {
		this.id = catalogoAbertura.getId();
		this.categoria = catalogoAbertura.getCategoria();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getCategoria() {
		return categoria;
	}
	
	public static List<CatalogoAberturaDto> converter(List<CatalogoAbertura> catalogoAbertura){
		
		return catalogoAbertura.stream().map(CatalogoAberturaDto::new).collect(Collectors.toList());
	}
	
	
}
