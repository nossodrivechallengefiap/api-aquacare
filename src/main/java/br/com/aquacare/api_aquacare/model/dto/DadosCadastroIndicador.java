package br.com.aquacare.api_aquacare.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroIndicador(
		@NotNull
		Long codigoLocal,
		
		@NotNull
		LocalDateTime dataHoraMedicao,
		
		@NotNull
		Long nivelColiformes,
		
		@NotNull
		BigDecimal nivelPh,
		
		@NotNull
		BigDecimal nivelOxigenioDissolvido,
		
		@NotNull
		BigDecimal nivelTurbidez,
		
		@NotNull
		BigDecimal nivelTemperatura
		) {

}
