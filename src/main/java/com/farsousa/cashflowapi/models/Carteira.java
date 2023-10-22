package com.farsousa.cashflowapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tab_carteira")
public class Carteira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false, length = 40)
	private String descricao;
	@Column(unique = false, nullable = false, scale = 2)
	private Double saldo;
	@Column(unique = false, nullable = false)
	private LocalDateTime horarioCriacao;
	@Column(unique = false, nullable = true)
	private LocalDateTime horarioAtualizacao;
	@Column(unique = false, nullable = true)
	private LocalDateTime horarioExclusao;
	@Column(unique = false, nullable = false)
	private boolean deletado;

}
