package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;
import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.persistence.AtendimentoPersistency;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;
import comhs.fundationdev.hairstyle.negocio.objects.Atendimento;
import java.util.List;

public class AtendimentoModel extends Model {
    private AtendimentoPersistency percistency;

    public AtendimentoModel(Context context) {
        this.contexto = context;
        this.percistency = new AtendimentoPersistency(context);
    }

    public void inserir(Object object) throws GenercicException {
        this.percistency.inserir((Atendimento) object);
    }

    public void inserir(String strObject) throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
    }

    public List buscarTodos() throws GenercicException {
        throw new UnsuportedOperationExeption(this.contexto.getResources().getString(R.string.usuported_exception));
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
        return this.percistency.alterarItem((Atendimento) item);
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
