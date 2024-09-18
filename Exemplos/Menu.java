import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Filme> filmes = new ArrayList<Filme>();

        do {
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Alugar Filme");
            System.out.println("3 - Listar Filmes");
            System.out.println("4 - Sair");
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção inválida");
                scanner.nextLine();
                continue;
            }
            switch (opt) {
                case 1:
                    System.out.println("Digite o título: ");
                    String titulo = scanner.next();
                    System.out.println("Digite a data de lançamento: ");
                    String dataLancamento = scanner.next();
                    System.out.println("Digite o gênero: ");
                    String genero = scanner.next();
                    System.out.println("Digite a classificação: ");
                    String classificacao = scanner.next();
                    System.out.println("Digite a duração: ");
                    double duracao = scanner.nextDouble();
                    Filme filme = new Filme(titulo, dataLancamento, genero, classificacao, duracao);
                    filmes.add(filme);
                    break;
                case 2:
                    System.out.println("Digite a posição do filme: ");
                    int pos = scanner.nextInt();
                    if (pos < 0 || pos >= filmes.size()) {
                        System.out.println("Filme não encontrado");
                        break;
                    }
                    filmes.get(pos).alugar();
                    break;
                case 3:
                    for (Filme filmePrint : filmes) {
                        System.out.println("Titulo: " + filmePrint.titulo);
                        System.out.println("Disponível: " + (filmePrint.disponivel ? "Sim" : "Não"));
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        } while (opt != 4);

        scanner.close();
    }
}
