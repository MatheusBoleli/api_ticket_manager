package br.com.surf.api_supplier_management.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.surf.api_supplier_management.model.CatalogoSolucao;
import br.com.surf.api_supplier_management.model.Ticket;
import br.com.surf.api_supplier_management.model.TicketStatus;
import br.com.surf.api_supplier_management.repository.CatalogoSolucaoRepository;
import br.com.surf.api_supplier_management.repository.TicketRepository;
import br.com.surf.api_supplier_management.repository.TicketStatusRepository;

public class SolucionarTicketForm {

	@NotNull @NotEmpty
	private String solucao;
	
	private String status = "FECHADO";
	
	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(LocalDateTime dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	private LocalDateTime dtFechamento = LocalDateTime.now();

	public Ticket solucionar(Long id, CatalogoSolucaoRepository catalogoSolucaoRepository, TicketRepository ticketRepository,
			TicketStatusRepository ticketStatusRepository) {

		CatalogoSolucao solucaoObj = catalogoSolucaoRepository.findBySolucao(this.solucao);
		
		Ticket ticketObj = ticketRepository.getById(id);
		TicketStatus ticketStatusObj = ticketStatusRepository.findByStatus(this.status);
		
		ticketObj.setCatalogoSolucao(solucaoObj);
		ticketObj.setTicketStatus(ticketStatusObj);
		ticketObj.setDataFechamento(this.dtFechamento);
		
		return ticketObj;
	}

	
}
