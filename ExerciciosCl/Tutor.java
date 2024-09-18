import java.util.ArrayList;

public class Tutor {

    String idTutor;
    String nomeTutor;
    String Telefone;
    String Email;
    static ArrayList<Tutor> tutores = new ArrayList<>();

    public Tutor(
    String idTutor,
    String nomeTutor,
    String Telefone,
    String Email
    ) {
        this.idTutor = idTutor;
        this.nomeTutor = nomeTutor;
        this.Telefone = Telefone;
        this.Email = Email;
    }
}