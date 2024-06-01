package br.com.aquacare.api_aquacare.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroLocal(
		@NotNull
		Long codigoCidade,
		
		@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotBlank
		@Size(max = 255)
		String descricao,
		
		@NotBlank
		@Size(max = 255)
		String latitude,
		
		@NotBlank
		@Size(max = 255)
		String longitude
		) {
}
