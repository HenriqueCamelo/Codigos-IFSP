package br.ifsp.granja.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifsp.granja.dto.despache.DespacheResponseDTO;
import br.ifsp.granja.model.Animal;
import br.ifsp.granja.model.Despache;
import br.ifsp.granja.repository.AnimalRepository;
import br.ifsp.granja.repository.DespacheRepository;

@Service
public class DespacheService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private DespacheRepository despacheRepository;

    @Transactional
    public void despacharAnimal(Long animalId, String motivo) {
        // busca o animal
        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + animalId));

        // cria o despache copiando apenas id e nome
        Despache despache = new Despache();
        despache.setAnimalId(animal.getId());
        despache.setNomeAnimal(animal.getNomeAnimal());
        despache.setMotivo(motivo);
        despache.setDataDespache(LocalDate.now());

        // salva o despache
        despacheRepository.save(despache);

        // remove o animal
        animalRepository.delete(animal);
    }

    public List<DespacheResponseDTO> getAllDespachadosDTO() {
    return despacheRepository.findAllByOrderByDataDespacheDesc()
        .stream()
        .map(d -> new DespacheResponseDTO(
            d.getAnimalId(),
            d.getNomeAnimal(),
            d.getDataDespache(),
            d.getMotivo()
        ))
        .collect(Collectors.toList());
}

}
