package br.ifsp.taskmaster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.ifsp.taskmaster.Service.TarefaService;
import br.ifsp.taskmaster.repository.TarefaRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskmasterApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@Mock
    private TarefaRepository tarefaRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarTarefa() throws Exception {
        String json = """
        {
            "titulo": "Estudo Spring Boot",
            "descricao": "Aprender Spring Data e MVC",
            "categoria": "Estudo",
            "dataLimite": "2025-10-10"
        }
        """;

        mockMvc.perform(post("/api/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Estudo Spring Boot"))
                .andExpect(jsonPath("$.categoria").value("Estudo"));
    }

    @Test
    public void testListarTarefas() throws Exception {
        mockMvc.perform(get("/api/tarefas?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    public void testBuscarTarefaPorCategoria() throws Exception {
        mockMvc.perform(get("/api/tarefas/search")
        .param("categoria", "Estudo")  // nome do parâmetro correto
        .param("page", "0")
        .param("size", "10"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content").isArray());
    }
	
}
