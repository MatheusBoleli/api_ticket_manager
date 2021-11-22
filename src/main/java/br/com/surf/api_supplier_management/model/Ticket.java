package br.com.surf.api_supplier_management.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String otrsTicket;
	private String fornecedorTicket;

	@ManyToOne
	private Fornecedores fornecedor;

	@ManyToOne
	private CatalogoAbertura catalogoAbertura;	

	@ManyToOne
	private CatalogoSolucao catalogoSolucao;;

	@ManyToOne
	private Criticidade criticidade;

	@ManyToOne
	private Usuario usuario;
	
	
	@ManyToOne
	private TicketStatus ticketStatus;

	private LocalDateTime dataAbertura = LocalDateTime.now();

	private LocalDateTime dataFechamento;

	
	public Ticket() {
	}

	public Ticket(String otrsTicket, String fornecedorTicket, Fornecedores fornecedor,
			Criticidade criticidade, CatalogoAbertura catalogoAbertura, CatalogoSolucao catalogoSolucao, TicketStatus ticketStatus) {
		this.otrsTicket = otrsTicket;
		this.fornecedorTicket = fornecedorTicket;
		this.fornecedor = fornecedor;
		this.criticidade = criticidade;
		this.catalogoAbertura = catalogoAbertura;
		this.ticketStatus = ticketStatus;
		this.catalogoSolucao = catalogoSolucao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtrsTicket() {
		return otrsTicket;
	}

	public void setOtrsTicket(String otrsTicket) {
		this.otrsTicket = otrsTicket;
	}

	public String getFornecedorTicket() {
		return fornecedorTicket;
	}

	public void setFornecedorTicket(String fornecedorTicket) {
		this.fornecedorTicket = fornecedorTicket;
	}

	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CatalogoAbertura getCatalogoAbertura() {
		return catalogoAbertura;
	}

	public void setCatalogoAbertura(CatalogoAbertura catalogoAbertura) {
		this.catalogoAbertura = catalogoAbertura;
	}

	public CatalogoSolucao getCatalogoSolucao() {
		return catalogoSolucao;
	}

	public void setCatalogoSolucao(CatalogoSolucao catalogoSolucao) {
		this.catalogoSolucao = catalogoSolucao;
	}

	public Criticidade getCriticidade() {
		return criticidade;
	}

	public void setCriticidade(Criticidade criticidade) {
		this.criticidade = criticidade;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
}
