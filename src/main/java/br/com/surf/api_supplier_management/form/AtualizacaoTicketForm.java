package br.com.surf.api_supplier_management.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.surf.api_supplier_management.model.CatalogoAbertura;
import br.com.surf.api_supplier_management.model.Criticidade;
import br.com.surf.api_supplier_management.model.Ticket;
import br.com.surf.api_supplier_management.repository.CatalogoAberturaRepository;
import br.com.surf.api_supplier_management.repository.CriticidadeRepository;
import br.com.surf.api_supplier_management.repository.TicketRepository;

public class AtualizacaoTicketForm {

	@NotNull @NotEmpty
	private String criticidade;
	@NotNull @NotEmpty
	private String categoria;
	
	
	public String getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(String criticidade) {
		this.criticidade = criticidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Ticket atualizar(Long id, TicketRepository ticketRepository, CriticidadeRepository criticidadeRepository, CatalogoAberturaRepository catalogoAberturaRepository) {

		Ticket ticketObj = ticketRepository.getById(id);
		Criticidade criticidadeObj = criticidadeRepository.findByCriticidade(criticidade);
		CatalogoAbertura catalogoAberturaObj = catalogoAberturaRepository.findByCategoria(categoria);
		
		ticketObj.setCatalogoAbertura(catalogoAberturaObj);
		ticketObj.setCriticidade(criticidadeObj);
		
		return ticketObj;
	}

	
}
