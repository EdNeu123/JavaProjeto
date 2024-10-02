import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(int id, 
    String nome, 
    int cargaHoraria, 
    Professor professor
    ) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        professor.adicionarCurso(this);
    }

    // Getters e Setters
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Curso: " + nome + ", Carga Horária: " + cargaHoraria + ", Professor: " + professor.getNome();
    }
}
