package com.prbv.microservice.microservicetest.gateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.prbv.microservice.microservicetest.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
