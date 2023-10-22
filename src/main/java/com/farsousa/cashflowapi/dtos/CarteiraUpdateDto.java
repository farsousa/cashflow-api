package com.farsousa.cashflowapi.dtos;

import java.time.LocalDateTime;
import com.farsousa.cashflowapi.models.Carteira;
import jakarta.validation.constraints.NotBlank;

public record CarteiraUpdateDto(
	@NotBlank(message = "A descrição não pode ser nula ou vazia!")
	String descricao
) {
	
	public Carteira toEntity() {
		Carteira carteira = new Carteira();
		carteira.setHorarioAtualizacao(LocalDateTime.now());
		carteira.setDescricao(descricao);
		return carteira;
	}
	
}
