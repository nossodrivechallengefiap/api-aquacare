package br.com.aquacare.api_aquacare.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aquacare.api_aquacare.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
