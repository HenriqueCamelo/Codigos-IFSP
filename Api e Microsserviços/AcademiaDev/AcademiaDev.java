import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;



public class AcademiaDev {
    public class Courses {
                    
        public String title; 
        public String description;
        public String instructorName;
        public Double durationInHours;// ??
        public DifficultyLevel difficultyLevel;
        public Status status;

        public enum DifficultyLevel { BEGINNER, INTERMEDIATE, ADVANCED };

        public enum Status { ACTIVE, INACTIVE };

        public String getTitle() {
		    return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getInstructorName() {
            return instructorName;
        }
        public void setInstructorName(String instructorName) {
            this.instructorName = instructorName;
        }
        public Double getDurationInHours() {
            return durationInHours;
        }
        public void setDurationInHours(Double durationInHours) {
            this.durationInHours = durationInHours;
        }
        public DifficultyLevel getDifficultyLevel() {
            return difficultyLevel;
        }
        public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
        }
        public Status getStatus() {
            return status;
        }
        public void setStatus(Status status) {
            this.status = status;
        }
    }



    public abstract class User{
        public String name;
        public String email;

        public User(String name, String email ){
            this.name = name;
            this.email = email;
        }

        public boolean ConsultarCatalogodeCursos(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }

        public boolean AbrirTicketdeSuporte(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }

        public boolean AutenticaçãoSimples(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }
    }



    public class SupportTicket {
        private String title;
        private String message;
        private User user;
        private LocalDateTime createdAt;
    }
    


    public class Admin extends User{

        public Admin(String name, String email) {
            super(name, email);

        }
        
        public boolean GerenciarStatusdeCursos(Courses currentCourse, String comando) {
            Courses alteradCourses = currentCourse;
            

            if (alteradCourses.getStatus() == AcademiaDev.Courses.Status.ACTIVE && comando.equalsIgnoreCase("desativar")) {
                alteradCourses.setStatus(AcademiaDev.Courses.Status.INACTIVE);
            }

            if (alteradCourses.getStatus() == AcademiaDev.Courses.Status.INACTIVE && comando.equalsIgnoreCase("ativar")) {
                alteradCourses.setStatus(AcademiaDev.Courses.Status.ACTIVE);
            }

            return true;
        }

        public SubscriptionPlan GerenciarPlanosdeAlunos(SubscriptionPlan currenSubscription, String comando) {

            switch(comando) {
            case "Basico":
                return new BasicPlan();
                
            case "Premium":
                return new PremiumPlan();
                
            default:
            System.out.println("Comando inválido. Retornando plano atual.");
            return currenSubscription;
            }

        }

        public boolean AtenderTicketsdeSuporte(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }

        public boolean GerarRelatórioseAnálises(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }

        public boolean ExportarDados(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }

        
        
    }
    


    public class Student extends User{

        public SubscriptionPlan subscriptionPlan;

        public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
            super(name, email);
            this.subscriptionPlan = subscriptionPlan;
        }

        public Enrollment MatricularemCurso(Courses enrollInACourse, Enrollment enrollment, Student student) {
            if (enrollInACourse.getStatus() == AcademiaDev.Courses.Status.ACTIVE) {
                Enrollment newEnrollment = new Enrollment(enrollInACourse, student);
                return newEnrollment;
            } else {
                System.err.println("O curso não foi aberto");
                return null;
            }
        }

        public List<String> ConsultarMatriculas(Enrollment currentEnrollments) {
            List<String> currentEnroledCourses = currentEnrollments
                .getCourses()
                .stream()
                .map(c -> c.title)
                .collect(Collectors.toList());
            return currentEnroledCourses;
            
        }

        public void AtualizarProgresso(Enrollment currentEnrollment, double progresso) {
            currentEnrollment.setProgress(progresso);
        }

        public boolean CancelarMatrícula(int currentEnrollments, String comando) {
            return currentEnrollments < 3;
        }


    }



    public class Enrollment {
        private Courses course;
        private Student student;
        private double progress; // 0.0 to 100.0

        private List<Courses> courses;

        public void setProgress(double progress) {
            this.progress = progress;
        }

        public Enrollment(Courses course , Student student){
            courses.add(course);
            this.student = student;
        }

        public List<Courses> getCourses() {
            return courses;
        }

    }



    public interface SubscriptionPlan {
        boolean canEnroll(int currentEnrollments);
        String getPlan();
    }



    public class BasicPlan implements SubscriptionPlan{

        @Override
        public boolean canEnroll(int currentEnrollments) {
            return currentEnrollments < 3;
        }

        @Override
        public String getPlan() {
            return "Basic";
        }
        
        

    }



    public class PremiumPlan implements SubscriptionPlan{

        @Override
        public boolean canEnroll(int currentEnrollments) {
            return true;
        }

        @Override
        public String getPlan() {
            return "Basic";
        }

        
        
    }
}
