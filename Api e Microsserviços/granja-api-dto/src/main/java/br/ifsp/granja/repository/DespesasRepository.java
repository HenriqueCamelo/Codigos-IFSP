package br.ifsp.granja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.granja.model.Despesas;

public interface DespesasRepository extends JpaRepository<Despesas, Long> {

}
