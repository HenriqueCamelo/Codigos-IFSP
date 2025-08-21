package src.service;

import java.util.*;
import java.util.stream.Collectors;

import src.model.Courses;
import src.model.Enrollment;
import src.model.Student;
import src.model.enums.DifficultyLevel;
import src.model.enums.CourseStatus;
import src.util.GenericCsvExporter;

public class ReportService {


    public List<Courses> listarCursosPorDificuldade(List<Courses> cursos, DifficultyLevel difficultyLevel) {
        return cursos.stream()
                .filter(c -> c.getDifficultyLevel() == difficultyLevel)
                .sorted(Comparator.comparing(Courses::getTitle))
                .collect(Collectors.toList());
    }


    public Set<String> listarInstrutoresAtivos(List<Courses> cursos) {
        return cursos.stream()
                .filter(c -> c.getStatus() == CourseStatus.ACTIVE)
                .map(Courses::getInstructorName)
                .collect(Collectors.toSet());
    }


    public Map<String, List<Student>> agruparAlunosPorPlano(List<Student> alunos) {
        return alunos.stream()
                .collect(Collectors.groupingBy(s -> s.getSubscriptionPlan().getPlan()));
    }


    public double calcularMediaProgresso(List<Student> alunos) {
        return alunos.stream()
                .flatMap(s -> s.getEnrollments().stream()) // pega todas as matrículas
                .mapToDouble(Enrollment::getProgress)
                .average()
                .orElse(0.0); // caso não haja matrículas
    }


    public Optional<Student> alunoComMaisMatriculas(List<Student> alunos) {
        return alunos.stream()
                .max(Comparator.comparingInt(s -> s.getEnrollments().size()));
    }
}
