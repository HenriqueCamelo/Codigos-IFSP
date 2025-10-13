package br.ifsp.granja.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.granja.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Page<Animal> findBynomeAnimalContainingIgnoreCase(String nome, Pageable pageable);
}
