package br.com.aquacare.api_aquacare.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuario(
		@NotNull
		Long codigoUsuario,
		
		@Size(max = 255)
		String nome,
		
		@Size(max = 255)
		String email,
		
		@Size(max = 255)
		String senha) {
}
