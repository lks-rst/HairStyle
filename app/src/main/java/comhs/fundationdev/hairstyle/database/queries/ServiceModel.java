package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;

import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.persistence.ServicePersistency;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;

public class ServiceModel extends Model {
    private ServicePersistency percistency;

    public ServiceModel(Context context) {
        this.contexto = context;
        this.percistency = new ServicePersistency(context);
    }

    public void inserir(Object object) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public void inserir(String strObject) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List buscarTodos() throws GenercicException {
        return this.percistency.buscarTodos();
    }

    public List buscarTodos(int min, int max) throws GenercicException {
        return this.percistency.buscarTodos(min, max);
    }

    public List buscarItensData(String dataInicail, String dataFinal) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List buscarTodos(String descricao) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List<String> buscarString() throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public Object buscarItem(int id) throws GenercicException {
        return buscarItem(String.valueOf(id));
    }

    public Object buscarItem(String referencia) throws GenercicException {
        return this.percistency.buscarItem(referencia);
    }

    public Boolean alterarItem(Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public Boolean alterarItem(Long id, Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public void excluirItem(Object item) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public void excluirItem(int id) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    /* access modifiers changed from: protected */
    public Object stringToObject(String objectString) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public Object buscarItem(int user, String pswrd) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public Object buscarItem(String user, String pswrd) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List buscarItens(int referencia, String secondCollun) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List buscarItens(String referencia, String secondCollun) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }
}
