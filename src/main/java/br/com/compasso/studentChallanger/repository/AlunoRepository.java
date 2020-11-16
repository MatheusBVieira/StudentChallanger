package br.com.compasso.studentChallanger.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.studentChallanger.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Page<Aluno> findByNomeCompleto(String nomeCompleto, Pageable paginacao);

	Page<Aluno> findByUsername(String username, Pageable paginacao);

}
