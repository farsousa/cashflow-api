package com.farsousa.cashflowapi.dtos;

import java.time.LocalDateTime;

import com.farsousa.cashflowapi.models.Carteira;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarteiraSaveDto(
	@NotBlank(message = "A descrição não pode ser nula ou vazia!")
	String descricao,
	@NotNull(message = "O saldo não pode ser nulo")
	Double saldo
) {
	
	public Carteira toEntity() {
		Carteira carteira = new Carteira();
		carteira.setHorarioCriacao(LocalDateTime.now());
		carteira.setDescricao(descricao);
		carteira.setSaldo(saldo);
		return carteira;
	}
	
}
