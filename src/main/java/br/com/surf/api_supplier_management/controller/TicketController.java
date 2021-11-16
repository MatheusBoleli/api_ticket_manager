package br.com.surf.api_supplier_management.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.surf.api_supplier_management.dto.TicketDto;
import br.com.surf.api_supplier_management.form.AtualizacaoTicketForm;
import br.com.surf.api_supplier_management.form.SolucionarTicketForm;
import br.com.surf.api_supplier_management.form.TicketForm;
import br.com.surf.api_supplier_management.model.Ticket;
import br.com.surf.api_supplier_management.repository.CatalogoAberturaRepository;
import br.com.surf.api_supplier_management.repository.CatalogoSolucaoRepository;
import br.com.surf.api_supplier_management.repository.CriticidadeRepository;
import br.com.surf.api_supplier_management.repository.FornecedoresRepository;
import br.com.surf.api_supplier_management.repository.TicketRepository;
import br.com.surf.api_supplier_management.repository.TicketStatusRepository;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private FornecedoresRepository fornecedoresRepository;
	
	@Autowired
	private CatalogoAberturaRepository catalogoAberturaRepository;
	
	@Autowired
	private CriticidadeRepository criticidadeRepository;
	
	@Autowired
	private TicketStatusRepository ticketStatusRepository;
	
	@Autowired
	private CatalogoSolucaoRepository catalogoSolucaoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeTickets")
	public Page<TicketDto> lista(@RequestParam(required = false) String otrs, @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		
		if (otrs == null) {
			Page<Ticket> ticket = ticketRepository.findAll(paginacao);
			return TicketDto.converter(ticket);
		} else {
			Page<Ticket> ticket = ticketRepository.findByOtrs(otrs, paginacao);
			return TicketDto.converter(ticket);
		}
	}
	
	
	@PostMapping
	@CacheEvict(value = "listaDeTickets", allEntries = true)
	public ResponseEntity<TicketDto> cadastrar(@RequestBody @Valid TicketForm form, UriComponentsBuilder uriBuilder){
		
		Ticket ticket = form.converter(catalogoAberturaRepository, fornecedoresRepository, criticidadeRepository, ticketStatusRepository, catalogoSolucaoRepository);
		
		ticketRepository.save(ticket);
		
		URI uri = uriBuilder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri();
		return ResponseEntity.created(uri).body(new TicketDto(ticket));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TicketDto> detalhar(@PathVariable Long id) {
		
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		if(ticket.isPresent()) {
			return ResponseEntity.ok(new TicketDto(ticket.get()));
			
		}else {
			
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTickets", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		if(ticket.isPresent()) {
			ticketRepository.deleteById(id);
			return ResponseEntity.ok().build();
			
		}else {
			return ResponseEntity.notFound().build();
		}
	
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTickets", allEntries = true)
	public ResponseEntity<TicketDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTicketForm form){
		
		Optional<Ticket> optional = ticketRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Ticket ticket = form.atualizar(id,ticketRepository, criticidadeRepository, catalogoAberturaRepository);
			return ResponseEntity.ok(new TicketDto(ticket));
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/solucionar/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTickets", allEntries = true)
	public ResponseEntity<TicketDto> solucionar(@PathVariable Long id, @RequestBody @Valid SolucionarTicketForm form){
		
		Optional<Ticket> optional = ticketRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Ticket ticket = form.solucionar(id, catalogoSolucaoRepository, ticketRepository, ticketStatusRepository);
			return ResponseEntity.ok(new TicketDto(ticket));
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
