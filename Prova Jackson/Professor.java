import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private int id;
    private String nome;
    private String departamento;
    private List<Curso> cursos;

    public Professor(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.cursos = new ArrayList<>();
    }

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

    public void exibir() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Cursos:");
        for (Curso curso : cursos) {
            System.out.println("  - " + curso.getNome() + " (Alunos: " + curso.getAlunos().size() + ")");
        }
    }

    public void salvar() {
        String sql = "INSERT INTO Professor (id, nome, departamento) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.nome);
            pstmt.setString(3, this.departamento);
            pstmt.executeUpdate();
            System.out.println("Professor salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
