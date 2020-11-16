package br.com.compasso.studentChallanger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compasso.studentChallanger.model.Administrador;

public interface UsuarioRepository extends JpaRepository<Administrador, Long> {

	Optional<Administrador> findByEmail(String email);

}
