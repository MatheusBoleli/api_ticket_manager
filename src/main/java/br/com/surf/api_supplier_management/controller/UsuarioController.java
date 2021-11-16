package br.com.surf.api_supplier_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surf.api_supplier_management.dto.UsuarioDto;
import br.com.surf.api_supplier_management.model.Usuario;
import br.com.surf.api_supplier_management.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> lista(){
		
		List<Usuario> usuario = usuarioRepository.findAll();
		
		return UsuarioDto.converter(usuario);
	}

}
