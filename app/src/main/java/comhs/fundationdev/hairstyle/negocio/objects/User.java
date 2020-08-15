package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class User extends Entidade {
    private int id;
    private String nome;
    private String pswd;
    private int tableMax;
    private int tableMin;

    public User() {
    }

    public User(JSONObject jsonObject) {
        try {
            setNome(jsonObject.getString("nome"));
            setId(jsonObject.getInt("id"));
        } catch (JSONException e) {
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id2) {
        this.id = id2;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome2) {
        this.nome = nome2;
    }

    public String getPswd() {
        return this.pswd;
    }

    public void setPswd(String pswd2) {
        this.pswd = pswd2;
    }

    public int getTableMin() {
        return this.tableMin;
    }

    public void setTableMin(int tableMin2) {
        this.tableMin = tableMin2;
    }

    public int getTableMax() {
        return this.tableMax;
    }

    public void setTableMax(int tableMax2) {
        this.tableMax = tableMax2;
    }

    public String toString() {
        return this.id + " - " + this.nome;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public Entidade toEntidade(JSONObject object) {
        try {
            setPswd(object.getString("pswd"));
            setNome(object.getString("nome"));
            setId(object.getInt("id"));
            return this;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject toJsonObject(Entidade object) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", getId());
            jsonObject.put("nome", getNome());
            jsonObject.put("pswd", getId());
        } catch (Exception e) {
        }
        return jsonObject;
    }
}
