package br.com.aquacare.api_aquacare.model.dto;

import br.com.aquacare.api_aquacare.model.entity.Local;

public record DadosListagemLocal(Long codigoLocal, String nomeCidade, String estado, String nomeLocal, String descricao, String latitude, String longitude) {
	public DadosListagemLocal (Local local) {
		this (
			local.getCodigoLocal(),
			local.getCidade().getNome(),
			local.getCidade().getEstado(),
			local.getNome(),
			local.getDescricao(),
			local.getLatitude(),
			local.getLongitude()
			);
	}
}