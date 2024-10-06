import java.util.Scanner;

public class Menu {
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
            scanner.nextLine(); // "Lembrete \n"

            switch (opcao) {
                case 1:
                    Metodos.cadastrarProfessor();
                    break;
                case 2:
                    Metodos.cadastrarCurso();
                    break;
                case 3:
                    Metodos.cadastrarAluno();
                    break;
                case 4:
                    Metodos.listarProfessores();
                    break;
                case 5:
                    Metodos.listarCursos();
                    break;
                case 6:
                    Metodos.listarAlunos();
                    break;
                case 0:
                    System.out.println("Você está saindo do programa!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
