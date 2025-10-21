package br.ifsp.granja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifsp.granja.model.Despache;

public interface DespacheRepository extends JpaRepository<Despache, Long> {
    List<Despache> findAllByOrderByDataDespacheDesc();
}
