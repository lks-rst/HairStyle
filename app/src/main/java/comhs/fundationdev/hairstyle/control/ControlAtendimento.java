package comhs.fundationdev.hairstyle.control;

import android.content.Context;
import android.widget.Toast;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.queries.AtendimentoModel;
import comhs.fundationdev.hairstyle.database.queries.ClientModel;
import comhs.fundationdev.hairstyle.database.queries.ServiceModel;
import comhs.fundationdev.hairstyle.database.queries.UserModel;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.negocio.objects.Atendimento;
import comhs.fundationdev.hairstyle.negocio.objects.Cliente;
import comhs.fundationdev.hairstyle.negocio.objects.Servico;
import comhs.fundationdev.hairstyle.negocio.objects.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControlAtendimento {
    private Atendimento atendimento = new Atendimento();
    private AtendimentoModel atendimentoModel;
    private ClientModel clientModel;
    private Cliente cliente;
    private List<Cliente> clientes;
    private Context ctx;
    private Boolean largeScreen;
    private int posicaoCliente = -1;
    private int posicaoServico = -1;
    private int posicaoUsuario = -1;
    private ServiceModel serviceModel;
    private Servico servico;
    private List<Servico> servicos;
    private UserModel userModel;
    private User usuario = new User();
    private List<User> usuarios;

    public ControlAtendimento(Context ctx2) {
        this.ctx = ctx2;
        this.clientModel = new ClientModel(ctx2);
        this.serviceModel = new ServiceModel(ctx2);
        this.atendimentoModel = new AtendimentoModel(ctx2);
        this.userModel = new UserModel(ctx2);
        if ((this.ctx.getResources().getConfiguration().screenLayout & 15) >= 3) {
            this.largeScreen = Boolean.valueOf(true);
        } else {
            this.largeScreen = Boolean.valueOf(false);
        }
    }

    public Boolean isLargeScreen() {
        return this.largeScreen;
    }

    public int getPosicaoUsuario() {
        return this.posicaoUsuario;
    }

    public void setPosicaoUsuario(int posicaoUsuario2) {
        this.posicaoUsuario = posicaoUsuario2;
        this.usuario = posicaoUsuario2 > 0 ? (User) this.usuarios.get(posicaoUsuario2 - 1) : null;
    }

    public int getPosicaoCliente() {
        return this.posicaoCliente;
    }

    public void setPosicaoCliente(int posicaoCliente2) {
        this.posicaoCliente = posicaoCliente2;
        this.cliente = posicaoCliente2 != -1 ? (Cliente) this.clientes.get(posicaoCliente2) : null;
    }

    public void setPosicaoServico(int posicaoServico2) {
        this.posicaoServico = posicaoServico2;
        this.servico = posicaoServico2 != -1 ? (Servico) this.servicos.get(posicaoServico2) : null;
    }

    public User getUsuario() {
        return this.usuario;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Servico getServico() {
        return this.servico;
    }

    public List<String> listarClientes() {
        List<String> listaClientes = new ArrayList<>();
        for (Cliente c : this.clientes) {
            listaClientes.add(c.toString());
        }
        return listaClientes;
    }

    public List<String> listarServicos() {
        List<String> listaServicos = new ArrayList<>();
        for (Servico ss : this.servicos) {
            listaServicos.add(ss.toString());
        }
        return listaServicos;
    }

    public List<String> listarUsuarios() {
        List<String> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(this.ctx.getString(R.string.users_prompt));
        for (User s : this.usuarios) {
            listaUsuarios.add(s.toString());
        }
        return listaUsuarios;
    }

    public Boolean indicarCliente(int cliente2) {
        boolean inserido;
        try {
            this.atendimento.setCliente((Cliente) this.clientes.get(cliente2 - 1));
            inserido = true;
        } catch (Exception e) {
            this.atendimento.setCliente(null);
            this.atendimento.getServicos();
            mostrar_toast("Atenção!\nO cliente indicado não pode ser inserido no atendimento");
            inserido = false;
            e.printStackTrace();
        }
        return Boolean.valueOf(inserido);
    }

    public boolean indicarValorServico(float valor) {
        try {
            Servico srvc = (Servico) this.atendimento.getServicos().get(this.atendimento.getServicos().size() - 1);
            srvc.setValorRealizado(valor);
            if (srvc.getValorMinimo() >= srvc.getValorRealizado() || srvc.getValorRealizado() >= srvc.getValorMaximo()) {
                mostrar_toast("Atenção!\nO valor indicado não pode ser realizado no serviço solicitado.\nO valor de ser entre: " + srvc.getValorMinimo() + " e " + srvc.getValorMaximo());
                return false;
            }
            this.atendimento.getServicos().add(this.atendimento.getServicos().indexOf(srvc), srvc);
            return true;
        } catch (Exception e) {
            mostrar_toast("Atenção!\nO valor indicado não pode ser realizado no serviço solicitado");
            e.printStackTrace();
            return false;
        }
    }

    public Boolean indicarServico(int servico2) {
        boolean inserido;
        try {
            Servico srvc = (Servico) this.servicos.get(servico2);
            this.servico = srvc;
            this.atendimento.addServico(srvc);
            inserido = true;
        } catch (Exception e) {
            e.printStackTrace();
            mostrar_toast("Atenção!\nO servico indicado não pode ser inserido no atendimento");
            inserido = false;
        }
        return Boolean.valueOf(inserido);
    }

    public int guardarAtendimento() {
        if (this.atendimento.getCliente() == null) {
            return 1;
        }
        this.atendimento.setAtendente(getUsuario());
        try {
            this.atendimentoModel.inserir((Object) this.atendimento);
            return 0;
        } catch (GenercicException e) {
            mostrar_toast("Atenção!\nO atendimento não pode ser encerrado no momento.\n Por favor aguarde");
            return -1;
        }
    }

    public boolean salvarAtendimento() {
        try {
            this.atendimento = new Atendimento();
            this.atendimento.setCliente(this.cliente);
            this.atendimento.setAtendente(this.usuario);
            this.atendimento.setServico(this.servico);
            Date data = new Date();
            int day = data.getDate();
            int month = data.getMonth() + 1;
            int year = data.getYear() + 1900;
            int hour = data.getHours();
            int minutes = data.getMinutes();
            int seconds = data.getSeconds();
            String sData = year + "-" + month + "-" + day;
            String sHora = hour + ":" + minutes + ":" + seconds;
            this.atendimento.setDataFim(sData);
            this.atendimento.setHoraFim(sHora);
            this.atendimentoModel.inserir((Object) this.atendimento);
            return true;
        } catch (GenercicException e) {
            mostrar_toast("Atenção!\nO atendimento não pode ser encerrado no momento.\n Por favor aguarde");
            return false;
        }
    }

    public void buscarClientes() {
        this.clientes = new ArrayList();
        try {
            this.clientes = this.clientModel.buscarTodos();
        } catch (GenercicException e) {
            e.printStackTrace();
            mostrar_toast("Não foram encontrados itens para a sua busca");
        }
    }

    public void buscarServicos() {
        this.servicos = new ArrayList();
        try {
            this.servicos = this.serviceModel.buscarTodos(this.usuario.getTableMin(), this.usuario.getTableMax());
        } catch (GenercicException e) {
            e.printStackTrace();
            mostrar_toast("Não foram encontrados itens para a sua busca");
        }
    }

    public void buscarUsuarios() {
        this.usuarios = new ArrayList();
        try {
            this.usuarios = this.userModel.buscarTodos();
        } catch (GenercicException e) {
            e.printStackTrace();
            mostrar_toast("Não foram encontrados itens para a sua busca");
        }
    }

    private void mostrar_toast(String texto) {
        Toast t = Toast.makeText(this.ctx, texto, 0);
        t.setGravity(1, 16, 0);
        t.show();
    }
}
