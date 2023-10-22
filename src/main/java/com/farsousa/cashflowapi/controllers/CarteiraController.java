package com.farsousa.cashflowapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farsousa.cashflowapi.dtos.CarteiraSaveDto;
import com.farsousa.cashflowapi.dtos.CarteiraUpdateDto;
import com.farsousa.cashflowapi.dtos.ResponseModel;
import com.farsousa.cashflowapi.models.Carteira;
import com.farsousa.cashflowapi.services.CarteiraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("carteira")
public class CarteiraController {
	
	public CarteiraService carteiraService;
	
	public CarteiraController(CarteiraService carteiraService) {
		this.carteiraService = carteiraService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel<Carteira>> criar(@RequestBody @Valid CarteiraSaveDto carteiraParaSalvar) throws Exception {		
		Carteira carteira = carteiraService.criar(carteiraParaSalvar);
		String status = "201 Created";
		String message = "Carteira criada!";
		
		ResponseModel<Carteira> resposta = new ResponseModel<>(message, status, carteira, null);
		
		return ResponseEntity.created(null).body(resposta);
	}
	
	@GetMapping
	public ResponseEntity<ResponseModel<Carteira>> listar(@PageableDefault(page = 0, size = 10) Pageable paginacao) {
		Page<Carteira> carteiras = carteiraService.listar(paginacao);
		String status = "200 Ok";
		String message = "Carteiras encontradas!";
		
		ResponseModel<Carteira> resposta = new ResponseModel<>(message, status, null, carteiras);
		
		return ResponseEntity.ok(resposta);
	}
	
	@GetMapping("{idCarteira}")
	public ResponseEntity<ResponseModel<Carteira>> buscarPorId(@PathVariable Long idCarteira) {
		Carteira carteira = carteiraService.buscarPorId(idCarteira);
		String status = "200 Ok";
		String message = "Carteira encontrada!";
		
		ResponseModel<Carteira> resposta = new ResponseModel<>(message, status, carteira, null);
		
		return ResponseEntity.ok(resposta);
	}
	
	@DeleteMapping("{idCarteira}")
	public ResponseEntity<ResponseModel<Carteira>> excluirPorId(@PathVariable Long idCarteira) {
		Carteira carteira = carteiraService.excluirPorId(idCarteira);
		String status = "200 Ok";
		String message = "Carteira excluída!";
		
		ResponseModel<Carteira> resposta = new ResponseModel<>(message, status, carteira, null);
		
		return ResponseEntity.ok(resposta);		
	}
	
	@PutMapping("{idCarteira}")
	public ResponseEntity<ResponseModel<Carteira>> criar(@PathVariable Long idCarteira, @RequestBody @Valid CarteiraUpdateDto carteiraParaAlterar) {		
		Carteira carteira = carteiraService.alterarPorId(idCarteira, carteiraParaAlterar);
		String status = "200 Ok";
		String message = "Carteira atualizada!";
		
		ResponseModel<Carteira> resposta = new ResponseModel<>(message, status, carteira, null);
		
		return ResponseEntity.created(null).body(resposta);
	}

}
