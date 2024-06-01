package br.com.aquacare.api_aquacare.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoCidade(
		@NotNull
		Long codigoCidade,
		
		@Size(max = 255)
		String nome,
		
		@Size(max = 255)
		String estado
		) {
}
