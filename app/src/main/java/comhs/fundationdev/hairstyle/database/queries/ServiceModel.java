package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;

import java.util.List;

import comhs.fundationdev.hairstyle.database.repository.persistence.PersistencySingleton;
import comhs.fundationdev.hairstyle.database.repository.persistence.ServicePersistency;
import comhs.fundationdev.hairstyle.exeption.GenercicException;

/**
 * Created by lucas on 11/02/16.
 */
public class ServiceModel extends Model{
    private ServicePersistency percistency;

    public ServiceModel(Context context)
    {
        super.contexto = context;
        this.percistency = new ServicePersistency(PersistencySingleton.getDataBase(context), context);
    }

    @Override
    public void inserir(Object object) throws GenercicException {

    }

    @Override
    public void inserir(String strObject) throws GenercicException {

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
        return null;
    }

    @Override
    public List<String> BuscarString() throws GenercicException {
        return null;
    }

    @Override
    public Object BuscarItem(int id) throws GenercicException {
        return null;
    }

    @Override
    public Boolean alterarItem(Object item) throws GenercicException {
        return null;
    }

    @Override
    public Boolean alterarItem(Long id, Object item) throws GenercicException {
        return null;
    }

    @Override
    public void ExcluirItem(Object item) throws GenercicException {

    }

    @Override
    public void ExcluirItem(int id) throws GenercicException {

    }

    @Override
    protected Object StringToObject(String objectString) throws GenercicException {
        return null;
    }
}
