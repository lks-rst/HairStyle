package comhs.fundationdev.hairstyle.negocio.objects;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 09/02/16.
 */
public class Atendimento extends Entidade{
    private Cliente cliente;
    private User atendente;
    private List<Servico> servicos;
    private int id;
    private String dataInicio;
    private String horaInicio;
    private String dataFim;
    private String horaFim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public User getAtendente() {
        return atendente;
    }

    public void setAtendente(User atendente) {
        this.atendente = atendente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "cliente=" + this.cliente +
                ", atendente=" + this.atendente +
                ", servicos=" + this.servicos +
                ", dataInicio='" + this.dataInicio + '\'' +
                ", horaInicio='" + this.horaInicio + '\'' +
                ", dataFim='" + this.dataFim + '\'' +
                ", horaFim='" + this.horaFim + '\'' +
                '}';
    }

    @Override
    public Entidade toEntidade(JSONObject object)
    {
        try {
            this.setCliente(new Cliente());
            this.setAtendente(new User());
            this.setServicos(new ArrayList<Servico>());
            this.setDataInicio(object.getString("dataInicio"));
            this.setHoraInicio(object.getString("dataInicio"));
            this.setDataFim(object.getString("dataFim"));
            this.setHoraFim(object.getString("horaFim"));
            this.setId(object.getInt("id"));
            return this;
        }
        catch (Exception e){return null;}
    }

    @Override
    public JSONObject toJsonObject(Entidade object) { return null; }
}
