package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import java.util.List;

public abstract class Model<T> {
    protected Context contexto;

    public abstract Boolean alterarItem(Long l, T t) throws GenercicException;

    public abstract Boolean alterarItem(T t) throws GenercicException;

    public abstract T buscarItem(int i) throws GenercicException;

    public abstract T buscarItem(int i, String str) throws GenercicException;

    public abstract T buscarItem(String str) throws GenercicException;

    public abstract T buscarItem(String str, String str2) throws GenercicException;

    public abstract List<T> buscarItens(int i, String str) throws GenercicException;

    public abstract List<T> buscarItens(String str, String str2) throws GenercicException;

    public abstract List<T> buscarItensData(String str, String str2) throws GenercicException;

    public abstract List<String> buscarString() throws GenercicException;

    public abstract List<T> buscarTodos() throws GenercicException;

    public abstract List<T> buscarTodos(String str) throws GenercicException;

    public abstract void excluirItem(int i) throws GenercicException;

    public abstract void excluirItem(T t) throws GenercicException;

    public abstract void inserir(T t) throws GenercicException;

    public abstract void inserir(String str) throws GenercicException;

    /* access modifiers changed from: protected */
    public abstract T stringToObject(String str) throws GenercicException;
}
