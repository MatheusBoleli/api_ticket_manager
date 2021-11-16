package br.com.surf.api_supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.Fornecedores;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long>{

	Fornecedores findByFornecedor(String fornecedor);
	
	
}
