package br.ifsp.granja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsp.granja.dto.despache.DespacheResponseDTO;
import br.ifsp.granja.service.DespacheService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/despaches")
public class DespacheController {

    @Autowired
    private DespacheService despacheService;

    @GetMapping
    public List<DespacheResponseDTO> listarDespachados() {
        return despacheService.getAllDespachadosDTO();
    }
}
