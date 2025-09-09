package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório para manipulação dos endereços no banco de dados.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
    
    /**
     * Método para buscar endereços pelo ID do contato.
     * 
     * @param contactId ID do contato.
     * @return Lista de endereços do contato.
     */
    List<Address> findByContactId(Long contactId);
}
