package comhs.fundationdev.hairstyle.negocio.objects;

import comhs.fundationdev.hairstyle.database.repository.tabelas.UserTable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class Atendimento extends Entidade {
    private User atendente;
    private Cliente cliente;
    private String dataFim;
    private String dataInicio;
    private String horaFim;
    private String horaInicio;
    private int id;
    private Servico servico;
    private List<Servico> servicos;

    public int getId() {
        return this.id;
    }

    public void setId(int id2) {
        this.id = id2;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente2) {
        this.cliente = cliente2;
    }

    public User getAtendente() {
        return this.atendente;
    }

    public void setAtendente(User atendente2) {
        this.atendente = atendente2;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico2) {
        this.servico = servico2;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public void removerServicos() {
        this.servicos.clear();
    }

    public void addServico(Servico servico2) {
        if (this.servicos == null) {
            this.servicos = new ArrayList();
        }
        this.servicos.add(servico2);
    }

    public void setServicos(List<Servico> servicos2) {
        this.servicos = servicos2;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(String dataInicio2) {
        this.dataInicio = dataInicio2;
    }

    public String getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(String horaInicio2) {
        this.horaInicio = horaInicio2;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(String dataFim2) {
        this.dataFim = dataFim2;
    }

    public String getHoraFim() {
        return this.horaFim;
    }

    public void setHoraFim(String horaFim2) {
        this.horaFim = horaFim2;
    }

    public String toString() {
        return "Atendimento{cliente=" + this.cliente + ", atendente=" + this.atendente + ", servicos=" + this.servicos + ", dataInicio='" + this.dataInicio + '\'' + ", horaInicio='" + this.horaInicio + '\'' + ", dataFim='" + this.dataFim + '\'' + ", horaFim='" + this.horaFim + '\'' + '}';
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public Entidade toEntidade(JSONObject object) {
        try {
            setCliente(new Cliente());
            setAtendente(new User());
            setServicos(new ArrayList());
            setDataInicio(object.getString("dataInicio"));
            setHoraInicio(object.getString("dataInicio"));
            setDataFim(object.getString("dataFim"));
            setHoraFim(object.getString("horaFim"));
            setId(object.getInt("id"));
            return this;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject toJsonObject(Entidade object) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cliente", getCliente().getCodigo());
            jsonObject.put(UserTable.NOME_TABELA, getAtendente().getId());
            jsonObject.put("servico", getServico().getCodigo());
            jsonObject.put("data", getDataFim());
            jsonObject.put("hora", getHoraFim());
        } catch (Exception e) {
        }
        return jsonObject;
    }
}
