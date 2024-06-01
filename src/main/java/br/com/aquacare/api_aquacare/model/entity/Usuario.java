package br.com.aquacare.api_aquacare.model.entity;

import br.com.aquacare.api_aquacare.model.dto.DadosAtualizacaoUsuario;
import br.com.aquacare.api_aquacare.model.dto.DadosCadastroUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "AC_USUARIO", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL_USUARIO", name = "UK_AC_USUARIO_EMAIL")
})
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AC_USUARIO")
	@SequenceGenerator(name = "SQ_AC_USUARIO", sequenceName = "SQ_AC_USUARIO", allocationSize = 1)
	@Column(name = "COD_USUARIO")
	private Long codigoUsuario;
	
	@Column(name = "NOME_USUARIO", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL_USUARIO", nullable = false)
	private String email;
	
	@Column(name = "SENHA_USUARIO", nullable = false)
	private String senha;

	// CONSTRUTORES
	public Usuario() {
	}
	
	public Usuario(Long codigoUsuario, String nome, String email, String senha) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.senha = dados.senha();
	}
	
	// ATUALIZAR
	public void atualizar(DadosAtualizacaoUsuario dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
	}
	
	// GETTERS & SETTERS
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [codigoUsuario=" + codigoUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ "]" + super.toString();
	}
}
