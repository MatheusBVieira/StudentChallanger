package br.com.compasso.studentChallanger.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.compasso.studentChallanger.controller.dto.AlunoDto;
import br.com.compasso.studentChallanger.controller.form.AlunoForm;
import br.com.compasso.studentChallanger.controller.form.AtualizacaoAlunoForm;
import br.com.compasso.studentChallanger.exception.IdNotFoundException;
import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Page<AlunoDto> lista(Pageable paginacao) {
		Page<Aluno> alunos = alunoRepository.findAll(paginacao);
		return AlunoDto.converter(alunos);
	}

	public Page<AlunoDto> lista(Pageable paginacao, String username) {
		Page<Aluno> alunos = alunoRepository.findByUsername(username, paginacao);
		return AlunoDto.converter(alunos);
	}

	public Page<AlunoDto> lista(String nomeCompleto, Pageable paginacao) {
		Page<Aluno> alunos = alunoRepository.findByNomeCompleto(nomeCompleto, paginacao);
		return AlunoDto.converter(alunos);
	}

	public Optional<Aluno> lista(Long id) {
		return alunoRepository.findById(id);
	}

	public Aluno insere(AlunoForm form) {
		Aluno aluno = form.converter();
		alunoRepository.save(aluno);
		return aluno;
	}

	public Aluno atualizar(Long id, AtualizacaoAlunoForm form) throws IdNotFoundException {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			Aluno aluno = form.atualizar(id, alunoRepository);
			return aluno;
		}
		throw new IdNotFoundException("Problema na atualização do aluno");
	}

	public boolean deleta(Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
