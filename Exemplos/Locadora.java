import java.util.ArrayList;

public class Locadora {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O Poderoso Chefão","24/03/1972","Drama","16 anos",177);
        filme1.atores.add("Marlon Brando");
        filme1.atores.add("Al Pacino");

        Filme filme2 = new Filme(
            "O Poderoso Chefão II",
            "24/03/1972",
            "Drama",
            "16 anos",
            202
        );
        filme2.atores.add("Al Pacino");
        filme2.atores.add("Robert De Niro");

        filme1.alugar();
        System.out.println("Objeto: ");
        System.out.println(filme1);
        System.out.println("Titulo: ");
        System.out.println(filme1.titulo);
        System.out.println("Disponível: " + (filme1.disponivel ? "Sim" : "Não"));
        
        System.out.println("Objeto: ");
        System.out.println(filme2);
        System.out.println("Titulo: ");
        System.out.println(filme2.titulo);
        System.out.println("Disponível: " + (filme2.disponivel ? "Sim" : "Não"));
        
        System.out.println("Desconto: " + Filme.desconto);
    }
}
