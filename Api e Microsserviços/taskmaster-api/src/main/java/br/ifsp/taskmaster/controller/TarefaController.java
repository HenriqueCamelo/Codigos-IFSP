package br.ifsp.taskmaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.ifsp.taskmaster.Service.TarefaService;
import br.ifsp.taskmaster.dto.tarefa.TarefaRequestDTO;
import br.ifsp.taskmaster.dto.tarefa.TarefaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/tarefas")
@Validated
public class TarefaController {
    
    
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }


    @Operation(summary = "Buscar todas as tarefas paginadas")
    @GetMapping
    public Page<TarefaResponseDTO> getAllTarefas(Pageable pageable){
        return tarefaService.listarTarefas(pageable);
    }

    @Operation(summary = "Buscar tarefa por ID")
    @GetMapping("{id}")
    public TarefaResponseDTO getTarefaById(@PathVariable Long id){
        return tarefaService.listarTarefas(Pageable.unpaged())
        .stream()
        .filter(t -> t.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Tarefa não encontrada: " + id));
    }

    @Operation(summary = "Criar nova tarefa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponseDTO createTarefa(@Valid @RequestBody TarefaRequestDTO dto){
        return tarefaService.criarTarefa(dto);
    }

    @Operation(summary = "Atualizar tarefa por ID")
    @PutMapping("/{id}")
    public TarefaResponseDTO updateTarefa(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO dto){
        return tarefaService.atualizarTarefa(id,dto);
    }

    @Operation(summary = "Atualização parcial da tarefa")
    @PatchMapping("/{id}")
    public TarefaResponseDTO updateTarefaPartial(@PathVariable Long id, @RequestBody TarefaRequestDTO dto){
        return tarefaService.atualizarTarefa(id, dto);

    }

    @Operation(summary = "Excluir Tarefa")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }

    @Operation(summary = "Buscar tarefa pela categoria")
    @GetMapping("/search")
    public Page<TarefaResponseDTO> searchTarefasByCategoria(@RequestParam String categoria, Pageable pageable){
        if(categoria != null && !categoria.isBlank()){
            return tarefaService.listarTarefasPorCategoria(categoria,pageable);

        }
        return tarefaService.listarTarefas(pageable);

    }
}
