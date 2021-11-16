package br.com.surf.api_supplier_management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "catalogo_solucao")
public class CatalogoSolucao {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String solucao;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSolucao() {
			return solucao;
		}

		public void setSolucao(String solucao) {
			this.solucao = solucao;
		}
		
}
