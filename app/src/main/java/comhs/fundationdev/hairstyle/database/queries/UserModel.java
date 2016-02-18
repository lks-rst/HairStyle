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
 * This must be the only way to get data from the dataBase no matter how to connect to it
 * for sqlite, or webservice or direct connection
 *
 * Created by lucas on 04/02/16.
 */
public class UserModel extends Model{
//    private  UserPersistency percistency;
    private ServerConect conection;

    public UserModel(Context context)
    {
        super.contexto = context;
        this.conection = new ServerConect(this.contexto,
                (this.contexto.getString(R.string.url_user)));
//        this.percistency = new UserPersistency(PersistencySingleton.getDataBase(context), context);
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
    public List BuscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List buscarTodos(String descricao) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List<String> BuscarString() throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public Object BuscarItem(int id) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
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
    public void ExcluirItem(Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public void ExcluirItem(int id) throws GenercicException {
        throw new UnsuportedOperationExeption(
                contexto.getResources().getString(R.string.usuported_exception));
    }

    @Override
    protected Object StringToObject(String objectString) throws GenercicException {
        return null;
    }


    /**
     * This method get the user id en try to select the user in the server if are mor then one user
     * with the same id an exeption is throw otherwise it compares the password passe with the one
     * returne from the server in the case it matches returns true otherwise returns false.
     *
     * @param user user cod to retriev
     * @param pswrd user password to compare at the database
     * @return
     * @throws GenercicException
     */
    public User getUser(int user, String pswrd) throws GenercicException
    {
        User usuario;
        try
        {
            JSONObject jsonObject = conection.readUser(user);
            usuario = new User();
            usuario = (User) usuario.toEntidade(jsonObject);
        } catch (Exception e)
        {
            usuario = null;
        }
        return usuario;
    }

    /**
     * This method get the user id en try to select the user in the server if are mor then one user
     * with the same id an exeption is throw otherwise it compares the password passe with the one
     * returne from the server in the case it matches returns true otherwise returns false.
     *
     * @param user user cod to retriev
     * @param pswrd user password to compare at the database
     * @return
     * @throws GenercicException
     */
    public User getUser(String user, String pswrd) throws GenercicException
    {
        User usuario;
        try
        {
            JSONObject jsonObject = conection.readUser(user);
            usuario = new User();
            usuario = (User) usuario.toEntidade(jsonObject);
        } catch (Exception e)
        {
            usuario = null;
        }
        return usuario;
    }
}
