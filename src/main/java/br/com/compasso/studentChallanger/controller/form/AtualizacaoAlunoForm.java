package br.com.compasso.studentChallanger.controller.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.model.Sexo;
import br.com.compasso.studentChallanger.repository.AlunoRepository;
import br.com.compasso.studentChallanger.utils.IdadeUtil;

public class AtualizacaoAlunoForm {

	private String nomeCompleto;
	private String email;
	private String telefone;
	private Sexo sexo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public Aluno atualizar(Long id, AlunoRepository alunoRepository) {
		Aluno aluno = alunoRepository.getOne(id);

		aluno.setNomeCompleto(nomeCompleto);
		aluno.setEmail(email);
		aluno.setTelefone(telefone);
		aluno.setSexo(sexo);
		aluno.setDataNascimento(dataNascimento);
		aluno.setIdade(IdadeUtil.calculaIdade(dataNascimento));

		return aluno;
	}

}
