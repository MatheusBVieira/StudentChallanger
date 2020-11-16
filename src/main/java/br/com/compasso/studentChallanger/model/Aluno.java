package br.com.compasso.studentChallanger.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeCompleto;
	@Column(unique = true)
	private String username;
	private String email;
	private String telefone;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private Integer idade;

	public Aluno(String nomeCompleto, String username, String email, String telefone, Sexo sexo, Date dataNascimento,
			Integer idade) {
		this.nomeCompleto = nomeCompleto;
		this.username = username;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}

	public Aluno() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
