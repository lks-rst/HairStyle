package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.Atendimento;
import comhs.fundationdev.hairstyle.util.ServerConect;

public class AtendimentoPersistency implements Persistencia<Atendimento> {
    private ServerConect conection;
    private Context ctx;
    private Connection myConnection;
    private StringBuilder sBuilder = new StringBuilder();
    private Statement statement;

    public AtendimentoPersistency(Context context) {
        this.ctx = context;
        this.conection = new ServerConect(context, context.getString(R.string.url_attendance_single_service));
        this.myConnection = PersistencySingleton.getMyDataBase(context);
    }

    public void inserir(Atendimento object) throws GenercicException {
        try {
            this.statement = this.myConnection.createStatement();
            this.statement.executeUpdate("insert into geral_prevenda(empre_codigo, prevenda_data, prevenda_codigo, prevenda_hora, repre_codigo, cli_codigo, prevenda_total) values (1, '" + object.getDataFim() + "', " + object.getServico().getCodigo() + ", '" + object.getHoraFim() + "', " + object.getAtendente().getId() + ", " + object.getCliente().getCodigo() + ", " + object.getServico().getValorRealizado() + ")");
            this.statement.setQueryTimeout(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Atendimento> buscarTodos() throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Atendimento> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Atendimento> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Atendimento buscarItem(String referencia) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Atendimento buscarItem(int referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Atendimento buscarItem(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<Atendimento> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Atendimento item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Long id, Atendimento item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(Atendimento item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
