package br.ifsp.granja.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.granja.dto.alimento.AlimentoRequestDTO;
import br.ifsp.granja.dto.alimento.AlimentoResponseDTO;
import br.ifsp.granja.model.Alimento;
import br.ifsp.granja.model.Animal;
import br.ifsp.granja.repository.AlimentoRepository;
import br.ifsp.granja.repository.AnimalRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Operation(summary = "Buscar todos os registros de alimento de um animal")
    @GetMapping("/animal/{animalId}")
    public Page<AlimentoResponseDTO> getAlimentoByAnimalId(@PathVariable Long animalId, Pageable pageable){
        return alimentoRepository.findByAnimalId(animalId,pageable)
                .map(alimento -> modelMapper.map(alimento, AlimentoResponseDTO.class));
    }

    @Operation(summary = "Buscar todos os registros de alimento de um animal")
    @PostMapping("/animal/{animalId}")
    public AlimentoResponseDTO createAlimento(@PathVariable Long animalId, @RequestBody AlimentoRequestDTO dto){
        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado" + animalId));

        Alimento alimento = modelMapper.map(dto, Alimento.class);
        alimento.setAnimal(animal);
        Alimento saved = alimentoRepository.save(alimento);
        return modelMapper.map(saved, AlimentoResponseDTO.class);
    }
}
