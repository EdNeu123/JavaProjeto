import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Aluno {
    private int id;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private Curso curso;

    public Aluno(int id, String nome, String dataNascimento, String cpf, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;
        curso.adicionarAluno(this);
    }

                            //Exibe as informações do aluno no coisa de texto do F5.
    public void exibir() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Curso: " + this.curso.getNome());
    }

                            //Salva as informações do aluno no banco de dados.
    public void salvar() {
        String sql = "INSERT INTO Aluno (id, nome, dataNascimento, cpf, idCurso) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, this.id);
            pstmt.setString(2, this.nome);
            pstmt.setString(3, this.dataNascimento);
            pstmt.setString(4, this.cpf);
            pstmt.setInt(5, this.curso.getId());
            pstmt.executeUpdate();
            System.out.println("Aluno salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
