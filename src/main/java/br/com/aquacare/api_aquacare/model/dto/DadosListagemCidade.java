package br.com.aquacare.api_aquacare.model.dto;

import br.com.aquacare.api_aquacare.model.entity.Cidade;

public record DadosListagemCidade(Long codigoCidade, String nome, String estado) {
	public DadosListagemCidade(Cidade cidade) {
		this (
				cidade.getCodigoCidade(),
				cidade.getNome(),
				cidade.getEstado()
			);
	}
}
