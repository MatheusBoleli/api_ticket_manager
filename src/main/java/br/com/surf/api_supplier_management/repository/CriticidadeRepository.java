package br.com.surf.api_supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.Criticidade;

@Repository
public interface CriticidadeRepository extends JpaRepository<Criticidade, Long>{
	
	Criticidade findByCriticidade(String criticidade);
	
}
