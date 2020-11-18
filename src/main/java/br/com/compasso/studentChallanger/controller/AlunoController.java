package br.com.compasso.studentChallanger.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.studentChallanger.controller.dto.AlunoDto;
import br.com.compasso.studentChallanger.controller.form.AlunoForm;
import br.com.compasso.studentChallanger.controller.form.AtualizacaoAlunoForm;
import br.com.compasso.studentChallanger.exception.IdNotFoundException;
import br.com.compasso.studentChallanger.model.Aluno;
import br.com.compasso.studentChallanger.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public Page<AlunoDto> lista(@RequestParam(required = false) String nomeCompleto,
			@RequestParam(required = false) String username,
			@PageableDefault(sort = "nomeCompleto", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		if (nomeCompleto == null && username == null) {
			return alunoService.lista(paginacao);
		} else {
			if (nomeCompleto == null) {
				return alunoService.lista(paginacao, username);
			} else {
				return alunoService.lista(nomeCompleto, paginacao);
			}
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> detalhar(@PathVariable Long id) {
		Optional<Aluno> aluno = alunoService.lista(id);
		if (aluno.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(aluno.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = alunoService.insere(form);

		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAlunoForm form) {
		try {
			Aluno aluno = alunoService.atualizar(id, form);
			return ResponseEntity.ok(new AlunoDto(aluno));
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		boolean deletado = alunoService.deleta(id);
		if (deletado) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
