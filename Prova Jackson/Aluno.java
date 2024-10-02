public class Aluno {
    private int id;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private Curso curso;

    public Aluno(
        int id, 
        String nome, 
        String dataNascimento, 
        String cpf, 
        Curso curso
    ){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;
        curso.adicionarAluno(this);
    }

    // Getters e Setters

    @Override
    public String toString() {
        return "Aluno: " + nome + ", Data de Nascimento: " + dataNascimento + ", CPF: " + cpf + ", Curso: " + curso.getNome();
    }
}
