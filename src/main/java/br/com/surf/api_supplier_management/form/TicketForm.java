package br.com.surf.api_supplier_management.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.surf.api_supplier_management.model.CatalogoAbertura;
import br.com.surf.api_supplier_management.model.CatalogoSolucao;
import br.com.surf.api_supplier_management.model.Criticidade;
import br.com.surf.api_supplier_management.model.Fornecedores;
import br.com.surf.api_supplier_management.model.Ticket;
import br.com.surf.api_supplier_management.model.TicketStatus;
import br.com.surf.api_supplier_management.repository.CatalogoAberturaRepository;
import br.com.surf.api_supplier_management.repository.CatalogoSolucaoRepository;
import br.com.surf.api_supplier_management.repository.CriticidadeRepository;
import br.com.surf.api_supplier_management.repository.FornecedoresRepository;
import br.com.surf.api_supplier_management.repository.TicketStatusRepository;

public class TicketForm {

	@NotNull @NotEmpty @Length(min = 18, max = 18)
	private String otrs;
	@NotNull @NotEmpty
	private String ticketFornecedor;
	@NotNull @NotEmpty
	private String fornecedor;
	@NotNull @NotEmpty
	private String criticidade;
	@NotNull @NotEmpty
	private String categoria;
	private String status = "ABERTO";
	private String solucao = "Não Solucionado";

	public String getOtrs() {
		return otrs;
	}

	public void setOtrs(String otrs) {
		this.otrs = otrs;
	}

	public String getTicketFornecedor() {
		return ticketFornecedor;
	}

	public void setTicketFornecedor(String ticketFornecedor) {
		this.ticketFornecedor = ticketFornecedor;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public Ticket converter(CatalogoAberturaRepository catalogoAberturaRepository,
			FornecedoresRepository fornecedoresRepository, CriticidadeRepository criticidadeRepository,
			TicketStatusRepository ticketStatusRepository, CatalogoSolucaoRepository catalogoSolucaoRepository) {

		CatalogoAbertura catalogoAberturaObj = catalogoAberturaRepository.findByCategoria(categoria);
		Fornecedores fornecedoresObj = fornecedoresRepository.findByFornecedor(fornecedor);
		Criticidade criticidadeObj = criticidadeRepository.findByCriticidade(criticidade);
		TicketStatus ticketStatusObj = ticketStatusRepository.findByStatus(status);
		CatalogoSolucao catalogoSolucaoObj = catalogoSolucaoRepository.findBySolucao(solucao);

		return new Ticket(this.otrs, this.ticketFornecedor, fornecedoresObj, criticidadeObj, catalogoAberturaObj,
				catalogoSolucaoObj, ticketStatusObj);
	}

}
