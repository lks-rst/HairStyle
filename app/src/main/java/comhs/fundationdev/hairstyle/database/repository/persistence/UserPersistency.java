package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;

import org.json.JSONObject;

import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.negocio.objects.User;
import comhs.fundationdev.hairstyle.util.ServerConect;

/**
 * Created by lucas on 04/02/16.
 */
public class UserPersistency implements Persistencia<User> {

    private Context ctx;
    private StringBuilder sBuilder;
    private ServerConect conection;

    public UserPersistency(Context context)
    {
        this.ctx = context;
        this.sBuilder = new StringBuilder();
        this.conection = new ServerConect(context, (context.getString(R.string.url_user)));
    }

    @Override
    public void inserir(User object) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void inserir(String strObject) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<User> buscarTodos() throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<User> buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<User> buscarTodos(String descricao) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public List<String> buscarString() throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public User buscarItem(String referencia) throws GenercicException {
        User usuario;
        try
        {
            JSONObject jsonObject = conection.readUser(referencia);
            usuario = new User();
            usuario = (User) usuario.toEntidade(jsonObject);
        } catch (Exception e)
        {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public User buscarItem(int referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public User buscarItem(String referencia, String secondCollun) throws GenercicException {
        User usuario;
        try
        {
            JSONObject jsonObject = conection.readUser(referencia);
            usuario = new User();
            usuario = (User) usuario.toEntidade(jsonObject);
        } catch (Exception e)
        {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public List<User> buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Boolean alterarItem(User item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public Boolean alterarItem(Long id, User item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void excluirItem(User item) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }

    @Override
    public void excluirItem(int id) throws GenercicException {
        throw new NotImplementedException(
                this.ctx.getResources().getString(R.string.notImplemented_exeption));
    }
}
