import java.util.ArrayList;
import java.util.List;

public class Professor {
    private int id;
    private String nome;
    private String departamento;
    private List<Curso> cursos;

    public Professor(
        int id, 
        String nome, 
        String departamento
        ){
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.cursos = new ArrayList<>();
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

        public String getNome() {
        return nome;
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        return "Professor: " + nome + ", Departamento: " + departamento;
    }
}
