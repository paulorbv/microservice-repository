package com.prbv.microservice.microservicetest.gateway.http;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prbv.microservice.microservicetest.domain.Cliente;
import com.prbv.microservice.microservicetest.gateway.dto.ClienteDTO;
import com.prbv.microservice.microservicetest.service.ClienteService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@Validated
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("meus/cliente")
	public List<ClienteDTO> buscarTodos() {
		
		List<ClienteDTO> clientesList = new ArrayList<>();
		
		Iterable<Cliente> clintes =  clienteService.buscarTodos();
		
		clintes.forEach(cliente -> clientesList.add(ClienteDTO.builder().name(cliente.getName()).id(cliente.getId()).build()));
		
		return clientesList;
	}

	@GetMapping("meus/cliente2")
	public List<Cliente> buscarTodos2() {
				
		
		List<Cliente> clintes =  clienteService.buscarTodos();
				
		
		return clintes;
	}	
	
	@PostMapping("meu/cliente")
	public void salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
		log.info("Nome do Cliente é " + clienteDTO.getName());
		
		Cliente cliente = Cliente.builder().name(clienteDTO.getName()).build();
		
		clienteService.salvar(cliente);
		
	}

}
