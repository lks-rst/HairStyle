package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

public class Servico extends Entidade {
    private int codigo;
    private String descricao;
    private float valorMaximo;
    private float valorMinimo;
    private float valorRealizado;

    public Servico() {
    }

    public Servico(JSONObject jsonObject) {
        try {
            setValorMinimo((float) jsonObject.getDouble("valorMinimo"));
            setValorMaximo((float) jsonObject.getDouble("valorMaximo"));
            setDescricao(jsonObject.getString("descricao"));
            setCodigo(jsonObject.getInt("id"));
        } catch (Exception e) {
        }
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo2) {
        this.codigo = codigo2;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao2) {
        this.descricao = descricao2;
    }

    public float getValorMinimo() {
        return this.valorMinimo;
    }

    public void setValorMinimo(float valorMinimo2) {
        this.valorMinimo = valorMinimo2;
    }

    public float getValorMaximo() {
        return this.valorMaximo;
    }

    public float getValorRealizado() {
        return this.valorRealizado;
    }

    public void setValorRealizado(float valorRealizado2) {
        this.valorRealizado = valorRealizado2;
    }

    public void setValorMaximo(float valorMaximo2) {
        this.valorMaximo = valorMaximo2;
    }

    public String toString() {
        return this.codigo + " - " + this.descricao;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public Entidade toEntidade(JSONObject object) {
        try {
            setValorMaximo((float) object.getDouble("valorMinimo"));
            setValorMinimo((float) object.getDouble("valorMaximo"));
            setDescricao(object.getString("descricao"));
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
