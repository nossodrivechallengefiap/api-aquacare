package br.com.aquacare.api_aquacare.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.aquacare.api_aquacare.model.entity.Indicador;

public record DadosListagemIndicador(
		Long codigoIndicador,
		String nome,
		String cidade,
		LocalDateTime dataHoraMedicao, 
		Long nivelColiformes,
		BigDecimal nivelPh, 
		BigDecimal nivelOxigenioDissolvido, 
		BigDecimal nivelTurbidez, 
		BigDecimal nivelTemperatura
		) 
{
	public DadosListagemIndicador (Indicador indicador) {
		this (
				indicador.getCodigoIndicador(),
				indicador.getLocal().getNome(),
				indicador.getLocal().getCidade().getNome(),
				indicador.getDataHoraMedicao(),
				indicador.getNivelColiformes(),
				indicador.getNivelPh(),
				indicador.getNivelOxigenioDissolvido(),
				indicador.getNivelTurbidez(),
				indicador.getNivelTemperatura()
			);
	}
}
