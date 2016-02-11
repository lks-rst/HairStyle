package comhs.fundationdev.hairstyle.negocio.objects;

import java.util.List;

/**
 * Created by lucas on 09/02/16.
 */
public class Atendimento extends Entidade{
    private Cliente cliente;
    private User atendente;
    private List<Servico> servicos;
    private String dataInicio;
    private String horaInicio;
    private String dataFim;
    private String horaFim;

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
}
