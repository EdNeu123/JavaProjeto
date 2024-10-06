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

    public int getId() { //Pegar ID
        return id;
    }

        public String getNome() { //Pegar Nome
        return nome;
    }

    public void adicionarCurso(Curso curso) { //Set Curso
        cursos.add(curso);
    }

    public List<Curso> getCursos() { //Pegar Curso
        return cursos;
    }

    public void exibir() { //Organização da listagem
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Cursos:");
        for (Curso curso : cursos) {
            System.out.println("  - " + curso.getNome() + " (Alunos: " + curso.getAlunos().size() + ")");
        }
    }
}
