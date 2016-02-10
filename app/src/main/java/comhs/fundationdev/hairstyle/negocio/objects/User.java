package comhs.fundationdev.hairstyle.negocio.objects;

/**
 * Created by lucas on 04/02/16.
 */
public class User extends Entidade{
    private int id;
    private String nome;
    private String pswd;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
}
