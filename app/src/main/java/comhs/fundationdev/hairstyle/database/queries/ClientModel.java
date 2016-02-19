package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;

import org.json.JSONObject;

import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;
import comhs.fundationdev.hairstyle.negocio.objects.User;
import comhs.fundationdev.hairstyle.util.ServerConect;

/**
 * Created by lucas on 11/02/16.
 */
public class ClientModel extends Model{
//    private ClientPersistency percistency;
    private ServerConect conection;

    public ClientModel(Context context)
    {
        super.contexto = context;
        this.conection = new ServerConect(this.contexto,
                (this.contexto.getString(R.string.url_user)));
//        this.percistency = new ClientPersistency(PersistencySingleton.getDataBase(context), context);
    }


    @Override
    public void inserir(Object object) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public void inserir(String strObject) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarTodos() throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarTodos(String descricao) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List<String> buscarString() throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public Object buscarItem(int id) throws GenercicException {
        User usuario;
        try
        {
            JSONObject jsonObject = conection.readUser(id);
            usuario = new User();
            usuario = (User) usuario.toEntidade(jsonObject);
        } catch (Exception e)
        {
            usuario = null;
        }
        return usuario;
    }

    @Override
    public Object buscarItem(String referencia) throws GenercicException {
        return null;
    }

    @Override
    public Boolean alterarItem(Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public Boolean alterarItem(Long id, Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public void excluirItem(Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public void excluirItem(int id) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    protected Object stringToObject(String objectString) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public Object buscarItem(int user, String pswrd) throws GenercicException
    {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public Object buscarItem(String user, String pswrd) throws GenercicException
    {throw new UnsuportedOperationExeption(
            contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarItens(int referencia, String secondCollun) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }
}
