package br.com.surf.api_supplier_management.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.surf.api_supplier_management.model.Ticket;

public class TicketDto {

	private Long id;
	private String otrsTicket;
	private String fornecedoresTicket;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFechamento;
	private String fornecedor;
	private String criticidade;
	private String catalogoAbertura;
	private String catalogoSolucao;
	private String ticketStatus;

	public TicketDto(Ticket ticket) {
		this.id = ticket.getId();
		this.otrsTicket = ticket.getOtrsTicket();
		this.fornecedoresTicket = ticket.getFornecedorTicket();
		this.dataAbertura = ticket.getDataAbertura();
		this.dataFechamento = ticket.getDataFechamento();
		this.fornecedor = ticket.getFornecedor().getFornecedor();
		this.criticidade = ticket.getCriticidade().getCriticidade();
		this.catalogoAbertura = ticket.getCatalogoAbertura().getCategoria();
		this.catalogoSolucao = ticket.getCatalogoSolucao().getSolucao();
		this.ticketStatus = ticket.getTicketStatus().getStatus();
	}

	public Long getId() {
		return id;
	}

	public String getOtrsTicket() {
		return otrsTicket;
	}

	public String getFornecedoresTicket() {
		return fornecedoresTicket;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public String getCriticidade() {
		return criticidade;
	}

	public String getCatalogoAbertura() {
		return catalogoAbertura;
	}

	public String getCatalogoSolucao() {
		return catalogoSolucao;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}
	

	public static Page<TicketDto> converter(Page<Ticket> ticket) {
		return ticket.map(TicketDto::new);
	}

}
