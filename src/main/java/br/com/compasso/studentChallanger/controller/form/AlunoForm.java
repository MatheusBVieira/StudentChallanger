package br.com.compasso.studentChallanger.controller.form;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.model.Sexo;

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
		Aluno aluno = new Aluno(nomeCompleto, username, email, telefone, sexo, dataNascimento, calculaIdade());
		return aluno;
	}

	public int calculaIdade() {
		GregorianCalendar agora = new GregorianCalendar();
		int ano = 0, mes = 0, dia = 0;

		GregorianCalendar nascimento = new GregorianCalendar();
		int anoNasc = 0, mesNasc = 0, diaNasc = 0;

		int idade = 0;

		if (this.getDataNascimento() != null) {
			nascimento.setTime(this.getDataNascimento());

			ano = agora.get(Calendar.YEAR);
			mes = agora.get(Calendar.MONTH) + 1;
			dia = agora.get(Calendar.DAY_OF_MONTH);

			anoNasc = nascimento.get(Calendar.YEAR);
			mesNasc = nascimento.get(Calendar.MONTH) + 1;
			diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);

			idade = ano - anoNasc;

			if (mes < mesNasc) {
				idade--;
			} else {
				if (dia < diaNasc) {
					idade--;
				}
			}

			if (idade < 0) {
				idade = 0;
			}

		}

		return (idade);
	}

}
