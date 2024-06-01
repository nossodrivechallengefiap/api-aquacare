package br.com.aquacare.api_aquacare.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.aquacare.api_aquacare.model.LocalRepository;
import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoIndicador;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroIndicador;
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
@Table(name = "AC_INDICADOR")
public class Indicador {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AC_INDICADOR")
	@SequenceGenerator(name = "SQ_AC_INDICADOR", sequenceName = "SQ_AC_INDICADOR", allocationSize = 1)
	@Column(name = "COD_INDICADOR")
	private Long codigoIndicador;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "COD_LOCAL",
			referencedColumnName = "COD_LOCAL",
			foreignKey = @ForeignKey(name = "FK_INDICADOR_LOCAL")
	)
	private Local local;
	
	@Column(name = "DT_MEDICAO")
	private LocalDateTime dataHoraMedicao;
	
	@Column(name = "NV_COLIFORMES")
	private Long nivelColiformes;
	
	@Column(name = "NV_PH")
	private BigDecimal nivelPh;
	
	@Column(name = "NV_OXIG_DISSOLVIDO")
	private BigDecimal nivelOxigenioDissolvido;
	
	@Column(name = "NV_TURBIDEZ")
	private BigDecimal nivelTurbidez;
	
	@Column(name = "NV_TEMPERATURA")
	private BigDecimal nivelTemperatura;

	// CONSTRUTORES
	public Indicador() {
		super();
	}
	
	public Indicador(Long codigoIndicador, Local local, LocalDateTime dataHoraMedicao, Long nivelColiformes,
			BigDecimal nivelPh, BigDecimal nivelOxigenioDissolvido, BigDecimal nivelTurbidez,
			BigDecimal nivelTemperatura) {
		super();
		this.codigoIndicador = codigoIndicador;
		this.local = local;
		this.dataHoraMedicao = dataHoraMedicao;
		this.nivelColiformes = nivelColiformes;
		this.nivelPh = nivelPh;
		this.nivelOxigenioDissolvido = nivelOxigenioDissolvido;
		this.nivelTurbidez = nivelTurbidez;
		this.nivelTemperatura = nivelTemperatura;
	}
	
	public Indicador (DadosCadastroIndicador dados) {
		this.dataHoraMedicao = dados.dataHoraMedicao();
		this.nivelColiformes = dados.nivelColiformes();
		this.nivelPh = dados.nivelPh();
		this.nivelOxigenioDissolvido = dados.nivelOxigenioDissolvido();
		this.nivelTurbidez = dados.nivelTurbidez();
		this.nivelTemperatura = dados.nivelTemperatura();
	}
	
	// ATUALIZAR
	public void atualizar (DadosAtualizacaoIndicador dados, LocalRepository localRepository) {
		if (dados.codigoLocal() != null) {
			this.local = localRepository.findById(dados.codigoLocal()).orElse(null);
		}
		
		if (dados.dataHoraMedicao() != null) {
			this.dataHoraMedicao = dados.dataHoraMedicao();
		}
		
		if (dados.nivelColiformes() != null) {
			this.nivelColiformes = dados.nivelColiformes();
		}
		
		if (dados.nivelPh() != null) {
			this.nivelPh = dados.nivelPh();
		}
		
		if (dados.nivelOxigenioDissolvido() != null) {
			this.nivelOxigenioDissolvido = dados.nivelOxigenioDissolvido();
		}
		
		if (dados.nivelTurbidez() != null) {
			this.nivelTurbidez = dados.nivelTurbidez();
		}
		
		if (dados.nivelTemperatura() != null) {
			this.nivelTemperatura = dados.nivelTemperatura();
		}
	}
	
	// Getters & Setters
	public Long getCodigoIndicador() {
		return codigoIndicador;
	}

	public void setCodigoIndicador(Long codigoIndicador) {
		this.codigoIndicador = codigoIndicador;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public LocalDateTime getDataHoraMedicao() {
		return dataHoraMedicao;
	}

	public void setDataHoraMedicao(LocalDateTime dataHoraMedicao) {
		this.dataHoraMedicao = dataHoraMedicao;
	}

	public Long getNivelColiformes() {
		return nivelColiformes;
	}

	public void setNivelColiformes(Long nivelColiformes) {
		this.nivelColiformes = nivelColiformes;
	}

	public BigDecimal getNivelPh() {
		return nivelPh;
	}

	public void setNivelPh(BigDecimal nivelPh) {
		this.nivelPh = nivelPh;
	}

	public BigDecimal getNivelOxigenioDissolvido() {
		return nivelOxigenioDissolvido;
	}

	public void setNivelOxigenioDissolvido(BigDecimal nivelOxigenioDissolvido) {
		this.nivelOxigenioDissolvido = nivelOxigenioDissolvido;
	}

	public BigDecimal getNivelTurbidez() {
		return nivelTurbidez;
	}

	public void setNivelTurbidez(BigDecimal nivelTurbidez) {
		this.nivelTurbidez = nivelTurbidez;
	}

	public BigDecimal getNivelTemperatura() {
		return nivelTemperatura;
	}

	public void setNivelTemperatura(BigDecimal nivelTemperatura) {
		this.nivelTemperatura = nivelTemperatura;
	}

	@Override
	public String toString() {
		return "Indicador [codigoIndicador=" + codigoIndicador + ", local=" + local + ", dataHoraMedicao="
				+ dataHoraMedicao + ", nivelColiformes=" + nivelColiformes + ", nivelPh=" + nivelPh
				+ ", nivelOxigenioDissolvido=" + nivelOxigenioDissolvido + ", nivelTurbidez=" + nivelTurbidez
				+ ", nivelTemperatura=" + nivelTemperatura + "]" + super.toString();
	}
}
