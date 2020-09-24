package com.prbv.microservice.microservicetest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prbv.microservice.microservicetest.domain.Cliente;
import com.prbv.microservice.microservicetest.gateway.repository.ClienteRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvar(Cliente cliente) {
		log.info("Salvando cliente " + cliente.getName());
		
		clienteRepository.save(cliente);
		
		log.info("Cliente Salvo com ID= " + cliente.getId());
	}
	
	public List<Cliente> buscarTodos() {
		log.info("Buscando clientes");
		
		return (List<Cliente>) clienteRepository.findAll();

	}	
	
}
