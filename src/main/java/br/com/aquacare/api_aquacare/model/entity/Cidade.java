package br.com.aquacare.api_aquacare.model.entity;

import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoCidade;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroCidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "AC_CIDADE", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"NM_CIDADE", "NM_ESTADO"}, name = "UK_EM_CIDADE_ESTADO")
})
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AC_CIDADE")
	@SequenceGenerator(name = "SQ_AC_CIDADE", sequenceName = "SQ_AC_CIDADE", allocationSize = 1)
	@Column(name = "COD_CIDADE")
	private Long codigoCidade;
	
	@Column(name = "NM_CIDADE", nullable = false)
	private String nome;
	
	@Column(name = "NM_ESTADO", nullable = false, length = 2)
	private String estado;
	
	// CONSTRUTORES
	public Cidade() {		
	}

	public Cidade(Long codigoCidade, String nome, String estado) {
		super();
		this.codigoCidade = codigoCidade;
		this.nome = nome;
		this.estado = estado;
	}
	
	public Cidade(DadosCadastroCidade dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
			this.estado = dados.estado();
		}
	}
	
	// ATUALIZAR
	public void atualizar (DadosAtualizacaoCidade dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.estado() != null) {
			this.estado = dados.estado();
		}
	}
	
	// Getters & Setters
	public Long getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Long codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cidade [codigoCidade=" + codigoCidade + ", nome=" + nome + ", estado=" + estado + "]" + super.toString();
	}
}
