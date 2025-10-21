package br.ifsp.granja.repository;

import br.ifsp.granja.model.Alimento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
    Page<Alimento> findByAnimalId(Long AnimalId, Pageable pageable);
}
