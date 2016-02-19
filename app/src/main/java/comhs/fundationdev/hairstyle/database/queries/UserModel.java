package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;

import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.persistence.UserPersistency;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;

/**
 * This must be the only way to get data from the dataBase no matter how to connect to it
 * for sqlite, or webservice or direct connection
 *
 * Created by lucas on 04/02/16.
 */
public class UserModel extends Model{
    private UserPersistency percistency;

    public UserModel(Context context)
    {
        super.contexto = context;
        this.percistency = new UserPersistency(context);
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
        return this.buscarItem(String.valueOf(id));
    }

    @Override
    public Object buscarItem(String referencia) throws GenercicException {
        return this.percistency.buscarItem(referencia);
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
        return this.buscarItem(String.valueOf(user), pswrd);
    }

    @Override
    public Object buscarItem(String user, String pswrd) throws GenercicException
    {
        return this.percistency.buscarItem(user, pswrd);
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
