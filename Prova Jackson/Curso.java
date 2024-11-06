import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;
    private Professor professor;
    private List<Aluno> alunos;

    public Curso(int id, String nome, int cargaHoraria, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        professor.adicionarCurso(this);
    }

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

    public void exibir() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Carga Horária: " + this.cargaHoraria);
        System.out.println("Professor: " + this.professor.getNome());
    }

    public void salvar() {
        String sql = "INSERT INTO Curso (id, nome, cargaHoraria, idProfessor) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.nome);
            pstmt.setInt(3, this.cargaHoraria);
            pstmt.setInt(4, this.professor.getId());
            pstmt.executeUpdate();
            System.out.println("Curso salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
