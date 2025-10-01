package br.ifsp.taskmaster.Service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import br.ifsp.taskmaster.dto.tarefa.TarefaRequestDTO;
import br.ifsp.taskmaster.dto.tarefa.TarefaResponseDTO;
import br.ifsp.taskmaster.exception.ResourceNotFoundException;
import br.ifsp.taskmaster.model.Tarefa;
import br.ifsp.taskmaster.repository.TarefaRepository;

@Service
public class TarefaService {
    
    private final TarefaRepository tarefaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository, ModelMapper modelMapper){
        this.tarefaRepository = tarefaRepository;
        this.modelMapper = modelMapper;
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto){
        validarDataLimite(dto.getDataLimite());

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setCategoria(dto.getCategoria());
        tarefa.setDataLimite(dto.getDataLimite());

        Tarefa saved = tarefaRepository.save(tarefa);
        return modelMapper.map(saved, TarefaResponseDTO.class);
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {
        Tarefa existing = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada: " + id));

        validarDataLimite(dto.getDataLimite());

        existing.setTitulo(dto.getTitulo());
        existing.setDescricao(dto.getDescricao());
        existing.setCategoria(dto.getCategoria());
        existing.setDataLimite(dto.getDataLimite());

        Tarefa updated = tarefaRepository.save(existing);
        return modelMapper.map(updated, TarefaResponseDTO.class);
    }

    public void deletarTarefa(Long id){
        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarefa não encontrada: "+ id);
        }
        tarefaRepository.deleteById(id);
    }

    public Page<TarefaResponseDTO> listarTarefas(Pageable pageable) {
        return tarefaRepository.findAll(pageable)
                .map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
    }

    public Page<TarefaResponseDTO> listarTarefasPorCategoria(String categoria, Pageable pageable) {
        return tarefaRepository.findByCategoriaIgnoreCase(categoria, pageable)
                .map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
    }

    private void validarDataLimite(LocalDate dataLimite) {
        if (dataLimite != null && dataLimite.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data limite não pode estar no passado");
        }
    }
}
