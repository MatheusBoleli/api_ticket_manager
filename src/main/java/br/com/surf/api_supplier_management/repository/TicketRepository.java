package br.com.surf.api_supplier_management.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.surf.api_supplier_management.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	@Query(value = "SELECT * FROM ticket t WHERE t.otrs_ticket =  :otrsTicket ", nativeQuery = true)
	Page<Ticket> findByOtrs(String otrsTicket, Pageable paginacao);
	
}
