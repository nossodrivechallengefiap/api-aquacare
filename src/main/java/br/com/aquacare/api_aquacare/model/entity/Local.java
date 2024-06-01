package br.com.aquacare.api_aquacare.model.entity;

import br.com.aquacare.api_aquacare.model.CidadeRepository;
import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoLocal;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroLocal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AC_LOCAL")
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AC_LOCAL")
	@SequenceGenerator(name = "SQ_AC_LOCAL", sequenceName = "SQ_AC_LOCAL", allocationSize = 1)
	@Column(name = "COD_LOCAL")
	private Long codigoLocal;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "COD_CIDADE",
			referencedColumnName = "COD_CIDADE",
			foreignKey = @ForeignKey(name = "FK_LOCAL_CIDADE")
	)
	private Cidade cidade;
	
	@Column(name = "NOME_LOCAL", nullable = false)
	private String nome;
	
	@Column(name = "DESC_LOCAL")
	private String descricao;
	
	@Column(name = "LATITUDE_LOCAL", nullable = false)
	private String latitude;
	
	@Column(name = "LONGITUDE_LOCAL", nullable = false)
	private String longitude;


	// CONSTRUTORES
	public Local() {
		
	}
	
	public Local(Long codigoLocal, Cidade cidade, String nome, String descricao, String latitude, String longitude) {
		super();
		this.codigoLocal = codigoLocal;
		this.cidade = cidade;
		this.nome = nome;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Local(DadosCadastroLocal dados) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.latitude = dados.latitude();
		this.longitude = dados.longitude();
	}
	
	// ATUALIZAR
	public void atualizar(DadosAtualizacaoLocal dados, CidadeRepository cidadeRepository) {
		if (dados.codigoCidade() != null) {
			this.cidade = cidadeRepository.findById(dados.codigoCidade()).orElse(null);
		}
		
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		
		if (dados.latitude() != null) {
			this.latitude = dados.latitude();
		}
		
		if (dados.longitude() != null) {
			this.longitude = dados.longitude();
		}
	}
	
	// GETTERS & SETTERS
	public Long getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Long codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitudade) {
		this.longitude = longitudade;
	}

	@Override
	public String toString() {
		return "Local [codigoLocal=" + codigoLocal + ", cidade=" + cidade + ", nome=" + nome + ", descricao="
				+ descricao + ", latitude=" + latitude + ", longitude=" + longitude + "]" + super.toString();
	}
}
