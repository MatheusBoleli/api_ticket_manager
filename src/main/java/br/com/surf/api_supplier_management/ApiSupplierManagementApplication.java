package br.com.surf.api_supplier_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class ApiSupplierManagementApplication {
	
	public static void main(String[] args) {
		//Teste de Push
		SpringApplication.run(ApiSupplierManagementApplication.class, args);
		
	}

}
