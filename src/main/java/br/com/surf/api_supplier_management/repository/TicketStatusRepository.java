package br.com.surf.api_supplier_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.TicketStatus;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long>{
	
	TicketStatus findByStatus(String status);
	
}
