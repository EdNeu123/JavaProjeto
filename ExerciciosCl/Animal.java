import java.util.ArrayList;

public class Animal {

    String idAnimal;
    String nomeAnimal;
    String racaAnimal;
    String pesoAnimal;
    static ArrayList<Animal> animais = new ArrayList<>();

    public Animal(
    String idAnimal,
    String nomeAnimal,
    String racaAnimal,
    String pesoAnimal
    ) {
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
        this.racaAnimal = racaAnimal;
        this.pesoAnimal = pesoAnimal;
    }
}

