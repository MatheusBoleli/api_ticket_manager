package br.com.surf.api_supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.CatalogoSolucao;

@Repository
public interface CatalogoSolucaoRepository extends JpaRepository<CatalogoSolucao, Long>{
	CatalogoSolucao findBySolucao(String solucao);
}
