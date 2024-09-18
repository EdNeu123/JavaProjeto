import java.util.ArrayList;

public class Filme {

    String titulo;
    String dataLancamento;
    String genero;
    String classificacao;
    double duracao;
    boolean disponivel = true;
    ArrayList<String> atores;
    static int desconto = 5;

    public Filme(
        String titulo,
        String dataLancamento,
        String genero,
        String classificacao,
        double duracao
    ) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
        this.atores = new ArrayList<String>();
    }

    public void alugar() {
        this.disponivel = false;
    }
    
}