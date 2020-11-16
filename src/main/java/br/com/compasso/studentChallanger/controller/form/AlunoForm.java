package br.com.compasso.studentChallanger.controller.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.model.Sexo;
import br.com.compasso.studentChallanger.utils.IdadeUtil;

public class AlunoForm {

	@NotNull
	private String nomeCompleto;

	@NotNull
	private String username;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String telefone;

	@NotNull
	private Sexo sexo;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

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

	public Aluno converter() {
		Aluno aluno = new Aluno(nomeCompleto, username, email, telefone, sexo, dataNascimento,
				IdadeUtil.calculaIdade(this.getDataNascimento()));
		return aluno;
	}

}
