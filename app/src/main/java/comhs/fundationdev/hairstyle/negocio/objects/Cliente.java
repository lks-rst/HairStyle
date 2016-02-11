package comhs.fundationdev.hairstyle.negocio.objects;

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
}
