package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

/**
 * Created by lucas on 09/02/16.
 */
public class Servico extends Entidade{
    private int codigo;
    private String descricao;
    private float valorMinimo;
    private float valorMaximo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(float valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public float getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(float valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigo=" + this.codigo +
                ", descricao='" + this.descricao + '\'' +
                ", valorMinimo=" + this.valorMinimo +
                ", valorMaximo=" + this.valorMaximo +
                '}';
    }

    @Override
    public Entidade toEntidade(JSONObject object)
    {
        try {
            this.setValorMaximo((float) object.getDouble("valorMinimo"));
            this.setValorMinimo((float) object.getDouble("valorMaximo"));
            this.setDescricao(object.getString("descricao"));
            this.setCodigo(object.getInt("id"));
            return this;
        }
        catch (Exception e){return null;}
    }

    @Override
    public JSONObject toJsonObject(Entidade object) {
        return null;
    }
}
