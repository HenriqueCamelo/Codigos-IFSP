package br.ifsp.granja.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.granja.model.VacinaAnimal;

public interface VacinaAnimalRepository extends JpaRepository<VacinaAnimal,Long> {
    Page<VacinaAnimal>findByAnimalId(Long Animalid, Pageable pageable);
}
