package src.service;

import java.util.List;
import java.util.stream.Collectors;

import src.model.Courses;
import src.model.Enrollment;
import src.model.Student;
import src.model.enums.CourseStatus;
import src.model.plans.SubscriptionPlan;
import src.util.exceptions.EnrollmentException;

public class EnrollmentService {
    
        public Enrollment MatricularemCurso(Courses enrollInACourse, Student aluno) {
            SubscriptionPlan plan = aluno.getSubscriptionPlan();

            if (enrollInACourse.getStatus() != CourseStatus.ACTIVE) {
                throw new EnrollmentException("O curso " + enrollInACourse.getTitle() + " está INATIVO.");
            }

            boolean alreadyEnrolled = aluno.getEnrollments()
                .stream()
                .anyMatch(e -> e.getCourse().getTitle().equalsIgnoreCase(enrollInACourse.getTitle()));

            if (alreadyEnrolled) {
                throw new EnrollmentException("Aluno já está matriculado neste curso.");
            }

            if (!plan.canEnroll(aluno.getEnrollments().size())) {
                throw new EnrollmentException("Limite de matrículas atingido para o plano " + plan.getPlan());
            }
            
            Enrollment newEnrollment = new Enrollment(enrollInACourse, aluno);
            aluno.getEnrollments().add(newEnrollment);
            
            return newEnrollment;
        }

        public List<String> ConsultarMatriculas(Student aluno) {
            List<String> currentEnroledCourses = aluno.getEnrollments()
                .stream()
                .map(c -> c.getCourse().getTitle() + " - "+ c.getProgress())
                .collect(Collectors.toList());
            return currentEnroledCourses;
            
        }

        public void AtualizarProgresso(Student aluno, Courses course, double progresso) {
            Enrollment updatedProgressEnrollment = aluno.getEnrollments()
                .stream()
                .filter(c -> c.getCourse().getTitle().equalsIgnoreCase(course.getTitle()))
                .findFirst()
                .orElseThrow(() -> new EnrollmentException("Aluno não está matriculado neste curso."));

            if (progresso < 0 || progresso > 100) {
                throw new EnrollmentException("Progresso deve estar entre 0 e 100.");
            }

            updatedProgressEnrollment.setProgress(progresso);
        }

        public void CancelarMatrícula(Student aluno, Courses course) {
            List<Enrollment> novaListaMatricula= aluno.getEnrollments()
                .stream()
                .filter(p -> !p.getCourse().getTitle().equals(course.title))
                .collect(Collectors.toList());
            aluno.setEnrollments(novaListaMatricula);

        }
}
