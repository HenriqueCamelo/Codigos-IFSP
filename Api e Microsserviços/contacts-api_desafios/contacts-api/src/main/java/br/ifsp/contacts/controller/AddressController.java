package br.ifsp.contacts.controller;

import br.ifsp.contacts.model.Address;
import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.AddressRepository;
import br.ifsp.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar as operações relacionadas aos endereços.
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    /**
     * Método para adicionar um novo endereço a um contato.
     * 
     * @param contactId ID do contato.
     * @param address Objeto Address com os dados do endereço.
     * @return O endereço criado.
     */
    @PostMapping("/contact/{contactId}")
    public Address createAddress(@PathVariable Long contactId, @RequestBody Address address) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com o ID: " + contactId));
        
        address.setContact(contact);  // Associa o endereço ao contato
        return addressRepository.save(address);
    }

    /**
     * Método para listar todos os endereços de um contato específico.
     * 
     * @param contactId ID do contato.
     * @return Lista de endereços.
     */
    @GetMapping("/contact/{contactId}")
    public List<Address> getAddressesByContactId(@PathVariable Long contactId) {
        return addressRepository.findByContactId(contactId);
    }
}
