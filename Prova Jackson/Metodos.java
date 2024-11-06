import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos { //metodos grosseiro, evitar poluição!
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarProfessor() {
        System.out.println("Digite o ID do Professor:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do Professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o departamento do Professor:");
        String departamento = scanner.nextLine();

        Professor professor = new Professor(id, nome, departamento);
        professor.salvar(); //metodo em professor para salvar no DB
        professores.add(professor); //metodo em professor para add no arraylist
        System.out.println("Professor cadastrado com sucesso!");
    } 

    public static void cadastrarCurso() {
        System.out.println("Digite o ID do Curso:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do Curso:");
        String nome = scanner.nextLine();
        System.out.println("Digite a carga horária do Curso:");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o ID do Professor responsável:");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Professor professor = professores.stream()
                .filter(p -> p.getId() == idProfessor)
                .findFirst()
                .orElse(null);

        if (professor != null) {
            Curso curso = new Curso(id, nome, cargaHoraria, professor);
            curso.salvar();
            cursos.add(curso);
            System.out.println("Curso cadastrado com sucesso!");
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    public static void cadastrarAluno() {
        System.out.println("Digite o ID do Aluno:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do Aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data de nascimento do Aluno:");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o CPF do Aluno:");
        String cpf = scanner.nextLine();

        if (!validarCPF(cpf)) {
            System.out.println("CPF inválido! Tente novamente.");
            return;
        }

        System.out.println("Digite o ID do Curso:");
        int idCurso = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursos.stream()
                .filter(c -> c.getId() == idCurso)
                .findFirst()
                .orElse(null);

        if (curso != null) {
            Aluno aluno = new Aluno(id, nome, dataNascimento, cpf, curso);
            aluno.salvar();
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    public static void listarProfessores() {
        for (Professor professor : professores) {
            professor.exibir();
        }
    }

    public static void listarCursos() {
        for (Curso curso : cursos) {
            curso.exibir();
        }
    }

    public static void listarAlunos() {
        for (Aluno aluno : alunos) {
            aluno.exibir();
        }
    }

    private static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            System.out.println("CPF deve ter 11 dígitos.");
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            System.out.println("CPF não pode ter todos os dígitos iguais.");
            return false;
        }

        int[] pesos = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        primeiroDigitoVerificador = (primeiroDigitoVerificador > 9) ? 0 : primeiroDigitoVerificador;

        pesos = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        segundoDigitoVerificador = (segundoDigitoVerificador > 9) ? 0 : segundoDigitoVerificador;

        boolean isValid = cpf.charAt(9) - '0' == primeiroDigitoVerificador
                && cpf.charAt(10) - '0' == segundoDigitoVerificador;
        if (!isValid) {
            System.out.println("Dígitos verificadores inválidos.");
        }
        return isValid;
    }

    public static void pausar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
        limparTela();
    }

    private static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
