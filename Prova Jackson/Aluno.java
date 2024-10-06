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

    public void exibir() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Curso: " + this.curso.getNome());
    }
}
