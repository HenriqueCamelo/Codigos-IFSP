package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import src.model.Admin;
import src.model.Courses;
import src.model.Enrollment;
import src.model.Student;
import src.model.SupportTicket;
import src.model.enums.CourseStatus;
import src.model.enums.DifficultyLevel;
import src.model.plans.BasicPlan;
import src.model.plans.PremiumPlan;
import src.service.CourseService;
import src.service.EnrollmentService;
import src.service.ReportService;
import src.service.SupportService;
import src.service.UserService;
import src.util.GenericCsvExporter;
import src.util.InitialData;
import src.util.exceptions.EnrollmentException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dados iniciais
        InitialData initialData = new InitialData();
        List<Student> students = initialData.getAlunosIniciais();
        List<Admin> admins = initialData.getAdminsIniciais();
        List<Courses> courses = initialData.getCursosIniciais();

        EnrollmentService  enrollmentService = new EnrollmentService();
        SupportService  supportService = new SupportService();
        CourseService courseService = new CourseService();
        ReportService reportService = new ReportService();


        UserService userService = new UserService(students, admins);

        System.out.println("=== Bem-vindo à Plataforma AcademiaDev ===");

        while (true) {

            
            
            System.out.print("\nDigite seu email para login (ou 'sair' para encerrar): ");
            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            }

            Optional<Object> usuario = userService.AutenticacaoSimples(email);

            if (usuario.isEmpty()) {
                System.out.println("Usuário não encontrado.");
                continue;
            }

            Object user = usuario.get();

            if (user instanceof Admin) {
                exibirMenuAdmin((Admin) user, scanner, userService, enrollmentService, supportService ,courses, students);
            } else if (user instanceof Student) {
                exibirMenuAluno((Student) user, scanner, courses, enrollmentService, supportService);
            }
        }

        scanner.close();
    }

    // ---------------------- MENU ADMIN ----------------------
    private static void exibirMenuAdmin(Admin admin, Scanner scanner, UserService userService, EnrollmentService  enrollmentService, SupportService  supportService, List<Courses> courses, List<Student> students) {
        
        
        while (true) {
            System.out.println("\n=== Menu do Administrador ===");
            System.out.println("1. Gerenciar Status de Cursos");
            System.out.println("2. Gerenciar Planos de Alunos");
            System.out.println("3. Atender Tickets de Suporte");
            System.out.println("4. Gerar Relatórios");
            System.out.println("5. Exportar Dados (CSV)");
            System.out.println("0. Logout");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Cursos disponíveis:");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(i + " - " + courses.get(i).getTitle() + " (" + courses.get(i).getStatus() + ")");
                    }
                    System.out.println("Digite o nome do curso que deseja atualizar o status:");
                    String nomeCursoStatus = scanner.nextLine();

                    Courses cursoStatusUpt = courses.stream()
                        .filter(c -> c.getTitle().equalsIgnoreCase(nomeCursoStatus))
                        .findFirst()
                        .orElse(null);

                    if (cursoStatusUpt == null) {
                        System.out.println("Curso não encontrado.");
                        break;
                    }

                    System.out.println("Digite o novo status (ativar ou destivar):");
                    String comandoStatus = scanner.nextLine();

                    
                    if (comandoStatus == null) {
                        System.out.println("Falha ao alterar status.");
                        break;
                    }

                    try {
                        CourseService.GerenciarStatusdeCursos(cursoStatusUpt, comandoStatus);;
                        System.out.println("Alteração feita");
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Alunos cadastrados:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + " - " + students.get(i).getName() + " (" + students.get(i).getSubscriptionPlan().getPlan() + ")");
                    }
                    System.out.print("Escolha o aluno: ");
                    int alunoIdx = Integer.parseInt(scanner.nextLine());
                    Student alunoEscolhido = students.get(alunoIdx);

                    System.out.print("Digite o novo plano (Basico/Premium): ");
                    String novoPlano = scanner.nextLine();
                    userService.GerenciarPlanosdeAlunos(alunoEscolhido, novoPlano);
                    break;
                case "3":
                    boolean resposta;
                    System.out.println("Atendendo ticket (simulação FIFO)...");
                    System.out.println(supportService.verProximoTicket());

                    System.out.println("Digite o status do ticket(atendido):");
                    String AtenderTicket = scanner.nextLine();

                    if(AtenderTicket.equals("atentido")){
                        resposta = true;
                    }else{
                        resposta = false;
                    }

                    try {
                        SupportTicket atendimento = supportService.AtenderTicketsdeSuporte(resposta);
                        System.out.println("Alteração feita");
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                    break;
                case "4": 
                    System.out.println("\n===== Relatórios =====");
                    System.out.println("1 - Alunos por Plano");
                    System.out.println("2 - Cursos Ativos");
                    System.out.println("3 - Cursos por dificuldade");
                    System.out.println("4 - Alunos com mais Cursos");
                    System.out.print("Escolha uma opção: ");

                    int opcRelatorio = scanner.nextInt();
                    scanner.nextLine();

                    ReportService reportService = new ReportService();

                    switch (opcRelatorio) {
                        case 1:
                            System.out.println(reportService.agruparAlunosPorPlano(students));
                            break;
                        case 2:
                            System.out.println(reportService.listarInstrutoresAtivos(courses));
                            break;
                        case 3:
                            System.out.println("Iniciante: " + reportService.listarCursosPorDificuldade(courses, DifficultyLevel.BEGINNER));
                            System.out.println("Intermediario: " + reportService.listarCursosPorDificuldade(courses, DifficultyLevel.INTERMEDIATE));
                            System.out.println("Avançado: " + reportService.listarCursosPorDificuldade(courses, DifficultyLevel.ADVANCED));
                            break;
                        case 4:
                            System.out.println(reportService.alunoComMaisMatriculas(students));
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case "5": 
                    System.out.println("\n===== Exportar Dados =====");
                    System.out.println("1 - Exportar Alunos");
                    System.out.println("2 - Exportar Cursos");
                    System.out.println("3 - Exportar Matrículas");
                    System.out.print("Escolha uma opção: ");

                    int opcExport = scanner.nextInt();
                    scanner.nextLine();

                    List<String> camposSelecionados;
                    String csv;

                    switch (opcExport) {
                        case 1:
                            System.out.println("Digite os campos de Student separados por vírgula (ex: name,email,subscriptionPlan.plan): ");
                            String camposAluno = scanner.nextLine();
                            camposSelecionados = List.of(camposAluno.split(","));
                            csv = GenericCsvExporter.exportToCsv(students, camposSelecionados, Student.class);
                            System.out.println("\n===== CSV =====\n" + csv);
                            break;

                        case 2:
                            System.out.println("Digite os campos de Courses separados por vírgula (ex: title,instructorName,status,difficultyLevel): ");
                            String camposCurso = scanner.nextLine();
                            camposSelecionados = List.of(camposCurso.split(","));
                            csv = GenericCsvExporter.exportToCsv(courses, camposSelecionados, Courses.class);
                            System.out.println("\n===== CSV =====\n" + csv);
                            break;

                        case 3:
                            List<Enrollment> todasMatriculas = students.stream()
                                    .flatMap(a -> a.getEnrollments().stream())
                                    .toList();

                            System.out.println("Digite os campos de Enrollment separados por vírgula (ex: student.name,student.email,course.title,progress): ");
                            String camposMatriculas = scanner.nextLine();
                            camposSelecionados = List.of(camposMatriculas.split(","));
                            csv = GenericCsvExporter.exportToCsv(todasMatriculas, camposSelecionados, Enrollment.class);
                            System.out.println("\n===== CSV =====\n" + csv);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case "0":
                    System.out.println("Logout realizado.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // ---------------------- MENU ALUNO ----------------------
    private static void exibirMenuAluno(Student student, Scanner scanner, List<Courses> courses, EnrollmentService  enrollmentService, SupportService  supportService) {
        
        while (true) {
            System.out.println("\n=== Menu do Aluno ===");
            System.out.println("1. Consultar Catálogo de Cursos");
            System.out.println("2. Matricular-se em Curso");
            System.out.println("3. Consultar Matrículas");
            System.out.println("4. Atualizar Progresso");
            System.out.println("5. Cancelar Matrícula");
            System.out.println("6. Abrir Ticket de Suporte");
            System.out.println("0. Logout");

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\nCursos Ativos:");
                    courses.stream()
                            .filter(c -> c.getStatus() == CourseStatus.ACTIVE)
                            .forEach(c -> System.out.println("- " + c.getTitle()));
                    break;
                
                
                case "2":
                    System.out.println("Matricular-se em curso (simulação)...");
                
                    System.out.println("Digite o nome do curso que deseja se matricular:");
                    String nomeCurso = scanner.nextLine();

                    Courses cursoSelecionado = courses.stream()
                        .filter(c -> c.getTitle().equalsIgnoreCase(nomeCurso))
                        .findFirst()
                        .orElse(null);

                    if (cursoSelecionado == null) {
                        System.out.println("Curso não encontrado.");
                        break;
                    }

                    try {
                        Enrollment matricula = enrollmentService.MatricularemCurso(cursoSelecionado, student);
                        System.out.println("Aluno matriculado no curso: " + matricula.getCourse().getTitle());
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }


                    break;
                
                
                case "3":
                    System.out.println("Cursos matriculados (simulação)...");
                    System.out.println(enrollmentService.ConsultarMatriculas(student));
                    break;
                
                
                case "4":
                    System.out.println("Atualizar progresso (simulação)...");
                    
                    System.out.println("Digite o nome do curso que deseja atualizar o progresso:");
                    String nomeCursoUpt = scanner.nextLine();

                    Courses cursoSelecionadoUpt = courses.stream()
                        .filter(c -> c.getTitle().equalsIgnoreCase(nomeCursoUpt))
                        .findFirst()
                        .orElse(null);

                    if (cursoSelecionadoUpt == null) {
                        System.out.println("Curso não encontrado.");
                        break;
                    }

                    System.out.println("Digite o novo progresso:");
                    double progreCursoUpt = scanner.nextDouble();
                    String finalLinha = scanner.nextLine();

                    Courses progreSelecionadoUpt = courses.stream()
                        .filter(c -> c.getTitle().equalsIgnoreCase(nomeCursoUpt))
                        .findFirst()
                        .orElse(null);

                    if (progreCursoUpt == 0) {
                        System.out.println("Falha ao alterar progresso.");
                        break;
                    }

                    try {
                        enrollmentService.AtualizarProgresso(student, cursoSelecionadoUpt, progreCursoUpt);
                        System.out.println(enrollmentService.ConsultarMatriculas(student));
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                    break;
                
                
                case "5":
                    System.out.println("Cancelar Matricula (simulação)...");    
                
                    System.out.println("Digite o nome do curso que deseja cancelar:");
                    String nomeCursoCancelar = scanner.nextLine();

                    Courses cursoSelecionadoCancelar = courses.stream()
                        .filter(c -> c.getTitle().equalsIgnoreCase(nomeCursoCancelar))
                        .findFirst()
                        .orElse(null);

                    if (cursoSelecionadoCancelar == null) {
                        System.out.println("Curso não encontrado.");
                        break;
                    }

                    try {
                        enrollmentService.CancelarMatrícula(student, cursoSelecionadoCancelar);
                        System.out.println(enrollmentService.ConsultarMatriculas(student));
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                    break;
                
                
                case "6":
                    System.out.println("Ticket aberto (simulação)...");

                    System.out.println("Digite o titulo do ticket:");
                    String tituloTicket = scanner.nextLine();
                    if (tituloTicket == null) {
                        System.out.println("É necessário a inserção de um título para o ticket.");
                        break;
                    }


                    System.out.println("Digite o conteúdo do ticket:");
                    String conteudoTicket = scanner.nextLine();
                    if (conteudoTicket == null) {
                        System.out.println("É necessário explicar o problema.");
                        break;
                    }


                    try {
                        supportService.AbrirTicketdeSuporte(tituloTicket, conteudoTicket, student);
                    } catch (EnrollmentException e) {
                        System.err.println("Erro: " + e.getMessage());
                    }

                    break;
                
                
                case "0":
                    System.out.println("Logout realizado.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
