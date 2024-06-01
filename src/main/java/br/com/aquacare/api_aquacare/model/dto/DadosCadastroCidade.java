package br.com.aquacare.api_aquacare.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCidade(
		@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotBlank
		@Size(max = 255)
		String estado) {

}
