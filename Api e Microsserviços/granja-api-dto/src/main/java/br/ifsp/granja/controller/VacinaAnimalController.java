package br.ifsp.granja.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.granja.dto.vacina.VacinaRequestDTO;
import br.ifsp.granja.dto.vacina.VacinaResponseDTO;
import br.ifsp.granja.model.Animal;
import br.ifsp.granja.model.VacinaAnimal;
import br.ifsp.granja.repository.AnimalRepository;
import br.ifsp.granja.repository.VacinaAnimalRepository;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaAnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VacinaAnimalRepository vacinaAnimalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "agrupar todas as vacinas do animal")
    @GetMapping("/animal/{animalId}")
    public Page<VacinaResponseDTO> getVacinaAnimalsByAnimalId(@PathVariable Long animalId, Pageable pageable){
        return vacinaAnimalRepository.findByAnimalId(animalId,pageable)
            .map(vacina -> modelMapper.map(vacina, VacinaResponseDTO.class));
    }
    
    @Operation(summary = "Inserir uma nova vacina ao animal")
    @PostMapping("/animal/{animalId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VacinaResponseDTO createVacina(@PathVariable Long animalId, @RequestBody VacinaRequestDTO dto){
        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + animalId));

        VacinaAnimal vacina = modelMapper.map(dto, VacinaAnimal.class);
        vacina.setAnimal(animal);
        VacinaAnimal saved = vacinaAnimalRepository.save(vacina);
        return modelMapper.map(saved, VacinaResponseDTO.class);
    }

}
