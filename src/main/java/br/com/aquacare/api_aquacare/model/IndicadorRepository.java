package br.com.aquacare.api_aquacare.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aquacare.api_aquacare.model.entity.Indicador;

public interface IndicadorRepository extends JpaRepository<Indicador, Long>{

}
