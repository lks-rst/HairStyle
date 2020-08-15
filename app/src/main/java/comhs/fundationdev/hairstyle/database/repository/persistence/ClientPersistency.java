package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.Cliente;
import comhs.fundationdev.hairstyle.util.ServerConect;

public class ClientPersistency implements Persistencia<Cliente> {
    private ServerConect conection;
    private Context ctx;
    private Connection myConnection;
    private StringBuilder sBuilder = new StringBuilder();
    private Statement statement;

    public ClientPersistency(Context context) {
        this.ctx = context;
        this.conection = new ServerConect(context, context.getString(R.string.url_client));
        this.myConnection = PersistencySingleton.getMyDataBase(context);
    }

    public void inserir(Cliente object) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Cliente> buscarTodos() throws GenercicException {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            this.statement = this.myConnection.createStatement();
            ResultSet set = this.statement.executeQuery("Select cli_codigo, cli_nome from geral_cliente");
            this.statement.setQueryTimeout(0);
            while (set.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(set.getInt("cli_codigo"));
                cliente.setNome(set.getString("cli_nome"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public List<Cliente> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Cliente> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Cliente buscarItem(String referencia) throws GenercicException {
        try {
            return (Cliente) new Cliente().toEntidade(this.conection.buscarItem(referencia));
        } catch (Exception e) {
            return null;
        }
    }

    public Cliente buscarItem(int referencia, String secondCollun) throws GenercicException {
        return buscarItem(String.valueOf(referencia), secondCollun);
    }

    public Cliente buscarItem(String referencia, String secondCollun) throws GenercicException {
        try {
            return (Cliente) new Cliente().toEntidade(this.conection.buscarItem(referencia));
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cliente> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Cliente item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Long id, Cliente item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(Cliente item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
