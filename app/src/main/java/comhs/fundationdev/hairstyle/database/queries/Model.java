package comhs.fundationdev.hairstyle.database.queries;

import android.content.Context;

import java.util.List;

import comhs.fundationdev.hairstyle.exeption.GenercicException;

/**
 * Created by lucas on 04/02/16.
 */
public abstract class Model<T> {
	protected Context contexto;

	public abstract void inserir(T object) throws GenercicException;
	
	public abstract void inserir(String strObject) throws GenercicException;
	
	public abstract List<T> buscarTodos() throws GenercicException;

	public abstract List<T> BuscarItensData(String dataInicail, String dataFinal) throws GenercicException;
	
	public abstract List<T> buscarTodos(String descricao) throws GenercicException;
	
	public abstract List<String> BuscarString() throws GenercicException;

	public abstract T BuscarItem(int id) throws GenercicException;
	
	public abstract Boolean alterarItem(T item) throws GenercicException;
	
	public abstract Boolean alterarItem(Long id, T item) throws GenercicException;
	
	public abstract void ExcluirItem(T item) throws GenercicException;
	
	public abstract void ExcluirItem(int id) throws GenercicException;
	
	protected abstract T StringToObject(String objectString) throws GenercicException;

}