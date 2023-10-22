package com.farsousa.cashflowapi.services;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.farsousa.cashflowapi.dtos.CarteiraSaveDto;
import com.farsousa.cashflowapi.dtos.CarteiraUpdateDto;
import com.farsousa.cashflowapi.exceptions.DadosNaoEncontradosException;
import com.farsousa.cashflowapi.models.Carteira;
import com.farsousa.cashflowapi.repositories.CarteiraRepository;
import com.farsousa.cashflowapi.util.ObjectUtil;

@Service
public class CarteiraService {
	
	private final CarteiraRepository carteiraRepository;
	private final String CARTEIRA_NAO_ENCONTRADA = "Nenhuma carteira foi encontrada!";
	private final String CARTEIRA_JA_EXISTE = "Carteira já  existe!";
	
	public CarteiraService(CarteiraRepository carteiraRepository) {
		this.carteiraRepository = carteiraRepository;
	}
	
	public Carteira criar(CarteiraSaveDto carteriaParaSalvar) throws Exception {
		Carteira carteira = null;
		try {
			carteira = buscarPorDescricao(carteriaParaSalvar.descricao());
			if(carteira.isDeletado()) {
				carteira.setDeletado(false);
				carteira.setSaldo(carteriaParaSalvar.saldo());
				carteira.setHorarioCriacao(LocalDateTime.now());
				carteira.setHorarioAtualizacao(null);
				carteira.setHorarioExclusao(null);
				return carteiraRepository.save(carteira);
			}
			throw new Exception(CARTEIRA_JA_EXISTE);
		}catch(DadosNaoEncontradosException ex) {
			carteira = carteriaParaSalvar.toEntity();
			return carteiraRepository.save(carteira);
		}		
	}
	
	public Page<Carteira> listar(Pageable paginacao) {
		Page<Carteira> carteiras = carteiraRepository.findAllByDeletadoFalse(paginacao);
		if(carteiras.isEmpty()) {
			throw new DadosNaoEncontradosException(CARTEIRA_NAO_ENCONTRADA);
		}
		return carteiras;
	}
	
	public Carteira buscarPorId(Long idCarteira) {
		return carteiraRepository.findByIdAndDeletadoFalse(idCarteira)
				.orElseThrow(() -> new DadosNaoEncontradosException(CARTEIRA_NAO_ENCONTRADA));
	}
	
	private Carteira buscarPorDescricao(String descricao) {
		return carteiraRepository.findByDescricao(descricao)
				.orElseThrow(() -> new DadosNaoEncontradosException(CARTEIRA_NAO_ENCONTRADA));
	}
	
	public Carteira excluirPorId(Long idCarteira) {
		Carteira carteira = buscarPorId(idCarteira);
		carteira.setDeletado(true);
		carteira.setHorarioExclusao(LocalDateTime.now());
		return carteiraRepository.save(carteira);
	}
	
	public Carteira alterarPorId(Long idCarteira, CarteiraUpdateDto carteiraParaAlterar)  {
		Carteira carteira = buscarPorId(idCarteira);
		carteira = ObjectUtil.mergeObjects(carteira, carteiraParaAlterar.toEntity());
		return carteira;
	}

}
