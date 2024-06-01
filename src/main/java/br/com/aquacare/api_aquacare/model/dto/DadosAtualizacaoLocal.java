package br.com.aquacare.api_aquacare.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoLocal(
		@NotNull
		Long codigoLocal,
		
		Long codigoCidade,
		
		@Size(max = 255)
		String nome,
		
		@Size(max = 255)
		String descricao,
		
		@Size(max = 255)
		String latitude,
		
		@Size(max = 255)
		String longitude) {
	
}
