package br.ifsp.granja.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.granja.dto.peso.PesoRequestDTO;
import br.ifsp.granja.dto.peso.PesoResponseDTO;
import br.ifsp.granja.model.Animal;
import br.ifsp.granja.model.Peso;
import br.ifsp.granja.repository.AnimalRepository;
import br.ifsp.granja.repository.PesoRepository;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/pesos")
public class PesoController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "Buscar todos os pesos de um animal")
    @GetMapping("/animal/{animalId}")
    public Page<PesoResponseDTO> getPesoByAnimalId(@PathVariable Long animalId, Pageable pageable){
        return pesoRepository.findByAnimalId(animalId,pageable)
                .map(peso -> modelMapper.map(peso, PesoResponseDTO.class));
    }

    @Operation(summary = "Buscar todos os pesos de um animal")
    @PostMapping("/animal/{animalId}")
    public PesoResponseDTO createPeso(@PathVariable Long animalId, @RequestBody PesoRequestDTO dto){
        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado" + animalId));

        Peso peso = modelMapper.map(dto, Peso.class);
        peso.setAnimal(animal);
        Peso saved = pesoRepository.save(peso);
        return modelMapper.map(saved, PesoResponseDTO.class);
    }
}
