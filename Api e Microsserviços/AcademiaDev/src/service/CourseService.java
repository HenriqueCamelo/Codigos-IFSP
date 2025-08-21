package src.service;

import java.util.List;

import src.model.Courses;
import src.model.Enrollment;
import src.model.enums.CourseStatus;

public class CourseService {
    
        public static void GerenciarStatusdeCursos(Courses currentCourse, String comando) {
            Courses alteradCourses = currentCourse;
            

            if (alteradCourses.getStatus() == CourseStatus.ACTIVE && comando.equalsIgnoreCase("desativar")) {
                alteradCourses.setStatus(CourseStatus.INACTIVE);
            }

            if (alteradCourses.getStatus() == CourseStatus.INACTIVE && comando.equalsIgnoreCase("ativar")) {
                alteradCourses.setStatus(CourseStatus.ACTIVE);
            }

            
        }

        public List<Courses> ConsultarCatalogodeCursos(Courses cursos) {
            return cursos.getCourses();
        }
}
