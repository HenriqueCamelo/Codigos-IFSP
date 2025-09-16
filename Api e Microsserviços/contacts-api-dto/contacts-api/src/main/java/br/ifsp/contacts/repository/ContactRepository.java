package br.ifsp.contacts.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifsp.contacts.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}