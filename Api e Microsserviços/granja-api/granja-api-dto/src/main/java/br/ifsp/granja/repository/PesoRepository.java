package br.ifsp.granja.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.granja.model.Peso;

public interface PesoRepository extends JpaRepository<Peso,Long>{
    Page<Peso> findByAnimalId(Long AnimalId, Pageable pageable);
}
