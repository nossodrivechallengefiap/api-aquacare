package br.com.aquacare.api_aquacare.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoIndicador(
		@NotNull
		Long codigoIndicador,
		
		Long codigoLocal,
		
		LocalDateTime dataHoraMedicao,
		
		Long nivelColiformes,
		
		BigDecimal nivelPh,
		
		BigDecimal nivelOxigenioDissolvido,
		
		BigDecimal nivelTurbidez,
		
		BigDecimal nivelTemperatura) {
}
