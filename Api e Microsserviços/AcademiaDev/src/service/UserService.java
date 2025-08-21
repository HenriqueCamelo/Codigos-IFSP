package src.service;

import java.util.List;
import java.util.Optional;

import src.model.Admin;
import src.model.Student;
import src.model.plans.BasicPlan;
import src.model.plans.PremiumPlan;
import src.model.plans.SubscriptionPlan;

public class UserService {
 
    private List<Student> students;
    private List<Admin> admins;

    public UserService(List<Student> students, List<Admin> admins) {
        this.students = students;
        this.admins = admins;
    }    
    
    public void GerenciarPlanosdeAlunos(Student student, String comando) {
            
            switch(comando) {
            case "Basico":
                student.setSubscriptionPlan(new BasicPlan());
                System.out.println("Plano alterado para Basic");
                break;
            case "Premium":
                student.setSubscriptionPlan(new PremiumPlan());
                System.out.println("Plano alterado para Premium");
                break;
            default:
                System.out.println("Comando inválido. Retornando plano atual.");
                student.getSubscriptionPlan();
                break;
            }

        }

        public Optional<Object> AutenticacaoSimples(String email) {
        return students.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .map(s -> (Object) s)
                .or(() -> admins.stream()
                        .filter(a -> a.getEmail().equalsIgnoreCase(email))
                        .findFirst()
                        .map(a -> (Object) a));
    }
}
