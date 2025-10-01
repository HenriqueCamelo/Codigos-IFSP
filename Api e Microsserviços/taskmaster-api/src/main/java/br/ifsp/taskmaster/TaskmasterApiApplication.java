package br.ifsp.taskmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Tarefas API", version = "1.0", description = "Exercicio TASKMASTER"))
@SpringBootApplication
public class TaskmasterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmasterApiApplication.class, args);
	}

}
