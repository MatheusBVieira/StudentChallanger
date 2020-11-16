package br.com.compasso.studentChallanger.controller.dto;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.model.Sexo;

public class AlunoDto {

	private String nomeCompleto;
	private String username;
	private String email;
	private String telefone;
	private Sexo sexo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private Integer idade;

	public AlunoDto(Aluno aluno) {
		this.nomeCompleto = aluno.getNomeCompleto();
		this.username = aluno.getUsername();
		this.email = aluno.getEmail();
		this.telefone = aluno.getTelefone();
		this.sexo = aluno.getSexo();
		this.dataNascimento = aluno.getDataNascimento();
		this.idade = aluno.getIdade();
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

	public static Page<AlunoDto> converter(Page<Aluno> alunos) {
		return alunos.map(AlunoDto::new);
	}

}
