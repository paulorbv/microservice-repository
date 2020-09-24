package com.prbv.microservice.microservicetest.gateway.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	@NotNull(message = "Nome é obrigatório")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String name;
	
	
	private Long id;
}
