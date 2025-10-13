package br.ifsp.granja.controller;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.granja.dto.despesas.DespesasResponseDTO;
import br.ifsp.granja.exception.ResourceNotFoundException;
import br.ifsp.granja.model.Despesas;
import br.ifsp.granja.repository.DespesasRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {
    
    @Autowired
    private DespesasRepository despesasRepository;

    @Autowired
    ModelMapper modelMapper;

    @Operation(summary = "Buscar por todos so animais")
    @GetMapping
    public Page<DespesasResponseDTO> getAllDespesas(Pageable pageable){
        Page<Despesas> despesas = despesasRepository.findAll(pageable);
        return despesas.map(despesa ->modelMapper.map(despesas, DespesasResponseDTO.class));
    }

    @Operation(summary = "Buscar animais por id")
    @GetMapping("/{id}")
    public DespesasResponseDTO getDespesasById(@PathVariable Long id){
        Despesas despesas = despesasRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Despesas não encontrado: "+ id));
        return modelMapper.map(despesas, DespesasResponseDTO.class);
            
    }

    @Operation(summary = "Criar nova despesa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DespesasResponseDTO createDespesa(@Valid @RequestBody DespesasResponseDTO dto){
        Despesas despesas = new Despesas(dto.getDataCompra(), dto.getEndereco(), dto.getCidade()
        , dto.getBairro(), dto.getCPF(),dto.getValor()
        ,dto.getNumeroParcelas(),dto.getFazenda());
        
        Despesas saved = despesasRepository.save(despesas);
        return modelMapper.map(saved, DespesasResponseDTO.class);
    }

    @PutMapping("/{id}")
    public DespesasResponseDTO updateDespesa(@PathVariable Long id, @Valid @RequestBody Despesas dto){
        Despesas existingDespesa = despesasRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Despesa não encontrado: " + id));

        existingDespesa.setDataCompra(dto.getDataCompra());
        existingDespesa.setEndereco(dto.getEndereco());
        existingDespesa.setCidade(dto.getCidade());
        existingDespesa.setBairro(dto.getBairro());
        existingDespesa.setCNPJCPF(dto.getCNPJCPF());
        existingDespesa.setValor(dto.getValor());
        existingDespesa.setNumeroParcelas(dto.getNumeroParcelas());
        existingDespesa.setFazenda(dto.getFazenda());

        Despesas updated = despesasRepository.save(existingDespesa);
        return modelMapper.map(updated, DespesasResponseDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteDespesa(@PathVariable Long id){
        if(!despesasRepository.existsById(id)){
            throw new ResourceNotFoundException("Animal não encontrado: "+ id);


        }
        
        despesasRepository.deleteById(id);
    }
}
