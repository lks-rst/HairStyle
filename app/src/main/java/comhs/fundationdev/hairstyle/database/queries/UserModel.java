package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.Banco;
import comhs.fundationdev.hairstyle.database.repository.persistence.PersistencySingleton;
import comhs.fundationdev.hairstyle.database.repository.persistence.UserPersistency;
import comhs.fundationdev.hairstyle.exeption.DataExeption;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.InsertionExeption;
import comhs.fundationdev.hairstyle.exeption.InvalidTypeExeption;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.exeption.ReadExeption;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;
import comhs.fundationdev.hairstyle.negocio.objects.User;

/**
 * Created by lucas on 04/02/16.
 */
public class UserModel extends Model{
    private  UserPersistency percistency;
    private Banco banco;
    private SQLiteDatabase db;

    public UserModel(Context context)
    {
        super.contexto = context;
        this.percistency = new UserPersistency(PersistencySingleton.getDataBase(context), context);
    }

    @Override
    public void inserir(Object object) throws GenercicException {
        try {
            percistency.inserir((User)object);
        } catch (Exception e) {
            throw new InsertionExeption(contexto.getResources().getString(R.string.insertion_exeption) + "\n" + e.getMessage());
        }
    }

    @Override
    public void inserir(String strObject) throws GenercicException {
        try {
            inserir(StringToObject(strObject));
        } catch (NotImplementedException e) {
            throw e;
        } catch (InvalidTypeExeption e) {
            throw e;
        } catch (GenercicException e) {
            throw e;
        } catch (Exception e) {
            throw new NotImplementedException(contexto.getResources().getString(R.string.notImplemented_exeption));
        }
    }

    @Override
    public List buscarTodos() throws GenercicException {
        return null;
    }

    @Override
    public List BuscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        return null;
    }

    @Override
    public List buscarTodos(String descricao) throws GenercicException {
        List<User> lista = new ArrayList<User>();

        lista = percistency.buscarTodos();

        if (lista.size() <= 0 )
            throw new ReadExeption(contexto.getResources().getString(R.string.read_exeption));
        else
            return lista;
    }

    @Override
    public List<String> BuscarString() throws GenercicException {
        List<User> lista = new ArrayList<User>();

        lista = percistency.buscarTodos();

        if (lista.size() <= 0 )
            throw new ReadExeption(contexto.getResources().getString(R.string.read_exeption));
        else
        {
            List<String> itens = new ArrayList<String>();
            for (User u: lista)
            {
                itens.add(u.toString());
            }
            return itens;
        }
    }

    @Override
    public Object BuscarItem(int id) throws GenercicException {
        try
        {
            return this.percistency.BuscarItem(id);
        } catch (Exception e)
        {
            throw new DataExeption(contexto.getResources().getString(R.string.database_exception));
        }
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
}
