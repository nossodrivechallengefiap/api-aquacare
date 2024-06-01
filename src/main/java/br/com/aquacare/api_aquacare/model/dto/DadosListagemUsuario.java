package br.com.aquacare.api_aquacare.model.dto;

import br.com.aquacare.api_aquacare.model.entity.Usuario;

public record DadosListagemUsuario(Long codigoUsuario, String nome, String email/*, String senha */ ) {
	public DadosListagemUsuario(Usuario usuario) {
		this (
				usuario.getCodigoUsuario(),
				usuario.getNome(),
				usuario.getEmail()
			);
	}
}
