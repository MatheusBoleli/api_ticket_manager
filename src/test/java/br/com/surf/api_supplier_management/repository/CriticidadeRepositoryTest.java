package br.com.surf.api_supplier_management.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.surf.api_supplier_management.model.Criticidade;

@DataJpaTest
public class CriticidadeRepositoryTest {
	
	@Autowired
	private CriticidadeRepository criticidadeRepository;
	
	@Test
	public void carregarCriticidades() {
		
		String criticidadeNome = "BAIXA";
		Criticidade criticidade = criticidadeRepository.findByCriticidade(criticidadeNome);
		
		Assert.assertNotNull(criticidadeNome = criticidade.getCriticidade());
		
	}

}
