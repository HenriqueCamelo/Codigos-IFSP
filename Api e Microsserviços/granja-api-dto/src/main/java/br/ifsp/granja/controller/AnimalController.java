package br.ifsp.granja.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.ifsp.granja.dto.animal.AnimalResponseDTO;
import br.ifsp.granja.model.Alimento;
import br.ifsp.granja.model.Animal;
import br.ifsp.granja.model.Peso;
import br.ifsp.granja.model.VacinaAnimal;
import br.ifsp.granja.repository.AnimalRepository;
import br.ifsp.granja.service.DespacheService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/animals")
@Validated
public class AnimalController {
    

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private DespacheService despacheService;

    @Operation(summary = "Buscar por todos so animais")
    @GetMapping
    public Page<AnimalResponseDTO> getAllAnimals(Pageable pageable){
        Page<Animal> animals = animalRepository.findAll(pageable);
        return animals.map(animal -> modelMapper.map(animal, AnimalResponseDTO.class));
    }

    @Operation(summary = "Buscar animal por ID")
    @GetMapping("/{id}")
    public AnimalResponseDTO getAnimalById(@PathVariable Long id){
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado: "+ id));
        return modelMapper.map(animal, AnimalResponseDTO.class);
        
    }

    @Operation(summary = "Buscar contato pelo nome")
    @GetMapping("/search")
    public Page<AnimalResponseDTO> searchAnimalByName(@RequestParam String name, Pageable pageable){
        return animalRepository.findBynomeAnimalContainingIgnoreCase(name, pageable)
            .map(animal ->modelMapper.map(animal, AnimalResponseDTO.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponseDTO createAnimal(@Valid @RequestBody AnimalResponseDTO dto) {
        Animal animal = new Animal(
            dto.getNomeAnimal(),
            dto.getSexoAnimal(),
            dto.getDataNascimentoAnimal(),
            dto.getFazenda(),
            dto.getGranja(),
            dto.getPaiAnimal(),
            dto.getMaeAnimal(),
            dto.getVendedor(),
            dto.getPrecoAnimal(),
            dto.getDataCompra(),
            dto.getDadosExtra()
    );

    // ✅ Converte VacinaResponseDTO → VacinaAnimal
    if (dto.getVacinas() != null && !dto.getVacinas().isEmpty()) {
        List<VacinaAnimal> vacinas = dto.getVacinas().stream()
            .map(v -> {
                VacinaAnimal va = new VacinaAnimal();
                va.setDataVacina(v.getDataVacina());
                va.setNomeVacina(v.getNomeVacina());
                va.setAnimal(animal);
                return va;
            })
            .toList();

        animal.setVacinas(vacinas);
    }

    // ✅ Mesmo raciocínio pode ser usado para pesos, se tiver DTO
    if (dto.getPesos() != null && !dto.getPesos().isEmpty()) {
        List<Peso> pesos = dto.getPesos().stream()
            .map(p -> {
                Peso peso = new Peso();
                peso.setDataPesagem(p.getDataPesagem());
                peso.setPesoAnimal(p.getPesoAnimal());
                peso.setAnimal(animal);
                return peso;
            })
            .toList();

        animal.setPesos(pesos);
    }

    if (dto.getAlimentos() != null && !dto.getAlimentos().isEmpty()) {
        List<Alimento> alimentos = dto.getAlimentos().stream()
            .map(p -> {
                Alimento alimento = new Alimento();
                alimento.setDataRegistroAlimento(p.getDataRegistroAlimento());
                alimento.setQuantidadeAgua(p.getQuantidadeAgua());
                alimento.setQuantidadeRacao(p.getQuantidadeRacao());
                alimento.setAnimal(animal);
                return alimento;
            })
            .toList();

        animal.setAlimentos(alimentos);
    }

    Animal saved = animalRepository.save(animal);
    return modelMapper.map(saved, AnimalResponseDTO.class);
}


    @PutMapping("/{id}")
    public AnimalResponseDTO updateAnimal(@PathVariable Long id, @Valid @RequestBody AnimalResponseDTO dto){
        Animal existingAnimal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + id));

        existingAnimal.setNomeAnimal(dto.getNomeAnimal());
        existingAnimal.setSexoAnimal(dto.getSexoAnimal());
        existingAnimal.setDataNascimentoAnimal(dto.getDataNascimentoAnimal());
        existingAnimal.setNomeAnimal(dto.getNomeAnimal());
        existingAnimal.setFazenda(dto.getFazenda());
        existingAnimal.setPaiAnimal(dto.getPaiAnimal());
        existingAnimal.setMaeAnimal(dto.getMaeAnimal());
        existingAnimal.setVendedor(dto.getVendedor());
        existingAnimal.setPrecoAnimal(dto.getPrecoAnimal());
        existingAnimal.setDataCompra(dto.getDataCompra());
        existingAnimal.setDadosExtra(dto.getDadosExtra());
        existingAnimal.setGranja(dto.getGranja());

        Animal updated = animalRepository.save(existingAnimal);
        return modelMapper.map(updated, AnimalResponseDTO.class);
    }

    @Operation(summary = "Deletar animal e registrar data de despache")
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id,
                             @RequestParam(required = false) String motivo) {
        despacheService.despacharAnimal(id, motivo);
    }
}
