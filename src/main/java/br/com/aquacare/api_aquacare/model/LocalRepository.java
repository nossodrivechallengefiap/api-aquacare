package br.com.aquacare.api_aquacare.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aquacare.api_aquacare.model.entity.Local;

public interface LocalRepository extends JpaRepository<Local, Long>{

}
