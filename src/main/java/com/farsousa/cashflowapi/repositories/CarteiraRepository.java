package com.farsousa.cashflowapi.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.cashflowapi.models.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long>{
	
	Page<Carteira> findAllByDeletadoFalse(Pageable paginacao);

	Optional<Carteira> findByIdAndDeletadoFalse(Long idCarteira);
	
	Optional<Carteira> findByDescricao(String descricao);

}
