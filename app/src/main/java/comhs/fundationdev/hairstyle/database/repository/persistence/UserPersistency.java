package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.User;
import comhs.fundationdev.hairstyle.util.ServerConect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserPersistency implements Persistencia<User> {
    private ServerConect conection;
    private Context ctx;
    private Connection myConnection;
    private StringBuilder sBuilder = new StringBuilder();
    private Statement statement;

    public UserPersistency(Context context) {
        this.ctx = context;
        this.conection = new ServerConect(context, context.getString(R.string.url_user_no_login));
        this.myConnection = PersistencySingleton.getMyDataBase(context);
    }

    public void inserir(User object) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<User> buscarTodos() throws GenercicException {
        List<User> listaUsuarios = new ArrayList<>();
        try {
            this.statement = this.myConnection.createStatement();
            ResultSet set = this.statement.executeQuery("Select repre_codigo, repre_descricao  from coiffeur.geral_representantes");
            this.statement.setQueryTimeout(0);
            while (set.next()) {
                User usuario = new User();
                usuario.setId(set.getInt("repre_codigo"));
                usuario.setNome(set.getString("repre_descricao"));
                usuario.setTableMin(1);
                usuario.setTableMax(2);
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public List<User> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<User> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public User buscarItem(String referencia) throws GenercicException {
        try {
            return new User(this.conection.buscarItem(referencia));
        } catch (Exception e) {
            return null;
        }
    }

    public User buscarItem(int referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public User buscarItem(String referencia, String secondCollun) throws GenercicException {
        try {
            return new User(this.conection.buscarUsuario(referencia));
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(User item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public Boolean alterarItem(Long id, User item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(User item) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
