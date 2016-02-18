package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

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
                "id=" + this.id +
                ", nome='" + this.nome + '\'' +
                ", pswd='" + this.pswd + '\'' +
                '}';
    }

    @Override
    public Entidade toEntidade(JSONObject object) {
        try {
            this.setPswd(object.getString("pswd"));
            this.setNome(object.getString("nome"));
            this.setId(Integer.parseInt(object.getString("id")));
            return this;
        } catch (Exception e){return null;}
    }

    @Override
    public JSONObject toJsonObject(Entidade object) {
        return null;
    }
}
