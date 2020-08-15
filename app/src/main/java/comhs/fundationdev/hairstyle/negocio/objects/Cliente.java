package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente extends Entidade {
    private int codigo;
    private String nome;

    public Cliente() {
    }

    public Cliente(JSONObject jsonObject) {
        try {
            setNome(jsonObject.getString("nome"));
            setCodigo(jsonObject.getInt("id"));
        } catch (JSONException e) {
        }
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo2) {
        this.codigo = codigo2;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome2) {
        this.nome = nome2;
    }

    public String toString() {
        return this.codigo + " - " + this.nome;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public Entidade toEntidade(JSONObject object) {
        try {
            setNome(object.getString("nome"));
            setCodigo(object.getInt("id"));
            return this;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject toJsonObject(Entidade object) {
        return null;
    }
}
