package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

/**
 * Created by lucas on 09/02/16.
 */
public class Cliente extends Entidade{
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + this.codigo +
                ", nome='" + this.nome + '\'' +
                '}';
    }

    @Override
    public Entidade toEntidade(JSONObject object)
    {
        try {
            this.setNome(object.getString("nome"));
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
