package src.util;

import java.util.ArrayList;
import java.util.List;

import src.model.Admin;
import src.model.Courses;
import src.model.Student;
import src.model.enums.CourseStatus;
import src.model.enums.DifficultyLevel;
import src.model.plans.BasicPlan;
import src.model.plans.PremiumPlan;

public class InitialData {
    public static List<Student> getAlunosIniciais() {
        List<Student> todosAlunos = new ArrayList<>();
        Student aluno1 = new Student("Caio", "CaioHard@gmail.com", new BasicPlan());
        Student aluno2 = new Student("Bianca", "Bianquinha@gmail.com", new BasicPlan());
        Student aluno3 = new Student("Thiago", "Thi@gmail.com", new PremiumPlan());

        todosAlunos.add(aluno1);
        todosAlunos.add(aluno2);
        todosAlunos.add(aluno3);

        return todosAlunos;
    }

    public static List<Admin> getAdminsIniciais() {
        List<Admin> todosAdmins = new ArrayList<>();
        Admin admin1 = new Admin("Rods", "Rodrigo@gmail.com");
        Admin admin2 = new Admin("Bia", "Beatriz@gmail.com");
        Admin admin3 = new Admin("Ternor", "Ternor@gmail.com");

        todosAdmins.add(admin1);
        todosAdmins.add(admin2);
        todosAdmins.add(admin3);

        return todosAdmins;
    }

    public static List<Courses> getCursosIniciais() {
        List<Courses> todosCursos = new ArrayList<>();

        Courses java = new Courses();
        java.setTitle("Java");
        java.setStatus(CourseStatus.ACTIVE);
        java.setDifficultyLevel(DifficultyLevel.ADVANCED);
        java.setInstructorName("Alex");
        todosCursos.add(java);

        Courses php = new Courses();
        php.setTitle("PHP");
        php.setStatus(CourseStatus.ACTIVE);
        php.setDifficultyLevel(DifficultyLevel.BEGINNER);
        php.setInstructorName("Marcos");
        todosCursos.add(php);

        Courses cMaisMais = new Courses();
        cMaisMais.setTitle("C++");
        cMaisMais.setStatus(CourseStatus.ACTIVE);
        cMaisMais.setDifficultyLevel(DifficultyLevel.INTERMEDIATE);
        cMaisMais.setInstructorName("Joelma");
        todosCursos.add(cMaisMais);

        Courses python = new Courses();
        python.setTitle("Python");
        python.setStatus(CourseStatus.ACTIVE);
        python.setDifficultyLevel(DifficultyLevel.ADVANCED);
        python.setInstructorName("Rosa");
        todosCursos.add(python);

        Courses sql = new Courses();
        sql.setTitle("SQL");
        sql.setStatus(CourseStatus.ACTIVE);
        sql.setDifficultyLevel(DifficultyLevel.INTERMEDIATE);
        sql.setInstructorName("Oswalda");
        todosCursos.add(sql);

        return todosCursos;
    }
}
