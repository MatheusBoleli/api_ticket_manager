package br.com.surf.api_supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.CatalogoAbertura;

@Repository
public interface CatalogoAberturaRepository extends JpaRepository<CatalogoAbertura, Long>{
	CatalogoAbertura findByCategoria(String categoria);
	
}
