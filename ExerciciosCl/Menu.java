import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
    int opt = 0;
    Scanner scanner = new Scanner(System.in);
    
    do{
        System.out.println("Esolha uma opção: ");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Cadastrar Categoria");
        System.out.println("3 - Cadastrar Tutor");
        System.out.println("4 - Listar Categoria"); 
        System.out.println("5 - Listar Animais");  
        System.out.println("6 - Listar Tutores");         
        System.out.println("7 - Sair");
        try {
            opt = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Opção inválida");
            scanner.nextLine();
            continue;
        }
        switch (opt) {
            case 1:
                System.out.println("Digite o codigo do seu pet: ");
                String idAnimal = scanner.next();
                System.out.println("Digite o nome do seu pet: ");
                String nomeAnimal = scanner.next();
                System.out.println("Digite a raça do seu pet: ");
                String racaAnimal = scanner.next();
                System.out.println("Qual o peso do animal: ");
                String pesoAnimal = scanner.next();
                Animal animal = new Animal(idAnimal, nomeAnimal, racaAnimal, pesoAnimal);
                Animal.animais.add(animal);
                break;
                //Fim Cadastro Animal
            case 2:
                System.out.println("Digite o codigo da categoria: ");
                String idCategoria = scanner.next();
                System.out.println("Descreva sua categoria: ");
                String descricao = scanner.next();
                Categoria categoria = new Categoria(idCategoria, descricao);
                Categoria.categorias.add(categoria);
                break;
                //Fim Cadastro Categoria
            case 3:
                System.out.println("Digite o codigo do tutor: ");
                String idTutor = scanner.next();
                System.out.println("Digite o nome do Tutor: ");
                String nomeTutor = scanner.next();
                System.out.println("Digite o Telefone do Tutor: ");
                String Telefone = scanner.next();
                System.out.println("Digite o mail do Tutor: ");
                String Email = scanner.next();
                Tutor tutorAnimal = new Tutor(idTutor, nomeTutor, Telefone, Email);
                Tutor.tutores.add(tutorAnimal);
                break;
                //Fim Cadastro Tutor
            case 4:
                for (Animal animaisPrint : animais) {
                    System.out.println("ID Animal: " + animaisPrint.idAnimal);
                    System.out.println("Nome Animal: " + animaisPrint.nomeAnimal);
                    System.out.println("Nome Rações: " + animaisPrint.racaAnimal);
                    System.out.println("Nome Peso: " + animaisPrint.pesoAnimal);
                }
                break;
                //Fim listar Animais    
            }
        } while (opt != 7);
        scanner.close();
    }
}
