import java.util.ArrayList;

public class Categoria{
    String idCategoria;
    String descricao;
    static ArrayList<Categoria> categorias = new ArrayList<>();

    public Categoria(
    String idCategoria,
    String descricao 
    ){
    this.idCategoria = idCategoria;
    this.descricao = descricao;
    }
}
