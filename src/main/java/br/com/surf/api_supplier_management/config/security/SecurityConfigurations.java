package br.com.surf.api_supplier_management.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	//Configurações de Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}
	
	//Configurações de Autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/ticket").permitAll()
		.antMatchers(HttpMethod.GET, "/ticket/*").permitAll()
		.antMatchers(HttpMethod.GET, "/catalogoAbertura").permitAll()
		;
		
		
		super.configure(http);
	}
	
	//Configurações de recursos estaticos (css, js, hmtl, imagens, etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	
	
}
