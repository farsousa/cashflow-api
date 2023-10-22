package com.farsousa.cashflowapi.dtos;

import org.springframework.data.domain.Page;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseModel<T>(
	String message,
	String status,
	T data,
	Page<T> page
) {}
