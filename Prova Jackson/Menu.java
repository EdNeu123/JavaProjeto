import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Pula linha "/n"

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarCurso();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 4:
                    listarProfessores();
                    break;
                case 5:
                    listarCursos();
                    break;
                case 6:
                    listarAlunos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarProfessor() {
        System.out.println("Digite o ID do Professor:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Pula linha "/n"
        System.out.println("Digite o nome do Professor:");
        String nome = scanner.nextLine();
        System.out.println("Digite o departamento do Professor:");
        String departamento = scanner.nextLine();

        Professor professor = new Professor(id, nome, departamento);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarCurso() {
        System.out.println("Digite o ID do Curso:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Pula linha "/n"
        System.out.println("Digite o nome do Curso:");
        String nome = scanner.nextLine();
        System.out.println("Digite a carga horária do Curso:");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); // Pula linha "/n"
        System.out.println("Digite o ID do Professor responsável:");
        int idProfessor = scanner.nextInt();
        scanner.nextLine(); // Pula linha "/n"

        Professor professor = professores.stream()
                .filter(p -> p.getId() == idProfessor) //chamando id professor
                .findFirst() //procure primeiro
                .orElse(null); // ou diferente de nulo

        if (professor != null) { //Se id Professor NÃO FOR NULO ele cadastra na arraylist curso, caso contrario ele informa que o id do professor nao foi encontrado.
            Curso curso = new Curso(id, nome, cargaHoraria, professor);
            cursos.add(curso);
            System.out.println("Curso cadastrado com sucesso!");
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    private static void cadastrarAluno() {
        System.out.println("Digite o ID do Aluno:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.println("Digite o nome do Aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite a data de nascimento do Aluno:");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite o CPF do Aluno:");
        String cpf = scanner.nextLine();
        if (!validarCPF(cpf)) { //chama função de validar CPF e se os valores forem retornados false ele retorna MSG de invalido
            System.out.println("CPF inválido! Tente novamente.");
            return;
        }
        System.out.println("Digite o ID do Curso:");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Pula linha "/n"

        Curso curso = cursos.stream()
                .filter(c -> c.getId() == idCurso)
                .findFirst()
                .orElse(null);

        if (curso != null) {
            Aluno aluno = new Aluno(id, nome, dataNascimento, cpf, curso);
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    private static void listarProfessores() {
        professores.forEach(professor -> {
            System.out.println(professor);
            professor.getCursos().forEach(curso -> {
                System.out.println("  Curso: " + curso.getNome() + ", Alunos: " + curso.getAlunos().size());
            });
        });
    }

    private static void listarCursos() {
        cursos.forEach(curso -> {
            System.out.println(curso);
        });
    }

    private static void listarAlunos() {
        alunos.forEach(aluno -> {
            System.out.println(aluno);
        });
    }

    private static boolean validarCPF(String cpf) {

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        // Calcula os dígitos verificadores
        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        primeiroDigitoVerificador = (primeiroDigitoVerificador > 9) ? 0 : primeiroDigitoVerificador;

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        segundoDigitoVerificador = (segundoDigitoVerificador > 9) ? 0 : segundoDigitoVerificador;

        // Verifica se os dígitos verificadores são iguais aos do CPF
        return cpf.charAt(9) - '0' == primeiroDigitoVerificador && cpf.charAt(10) - '0' == segundoDigitoVerificador;
    }

}
