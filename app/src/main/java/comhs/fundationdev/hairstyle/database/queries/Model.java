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

	public abstract List<T> buscarItensData(String dataInicail, String dataFinal) throws GenercicException;
	
	public abstract List<T> buscarTodos(String descricao) throws GenercicException;
	
	public abstract List<String> buscarString() throws GenercicException;

	public abstract T buscarItem(int referencia) throws GenercicException;

	public abstract T buscarItem(String referencia) throws GenercicException;

	public abstract T buscarItem(int referencia, String secondCollun) throws GenercicException;

	public abstract T buscarItem(String referencia, String secondCollun) throws GenercicException;

	/**
	 * This method get the user id en try to select the user in the server if are mor then one user
	 * with the same id an exeption is throw otherwise it compares the password passe with the one
	 * returne from the server in the case it matches returns true otherwise returns false.
	 *
	 * @param referencia user cod to retriev
	 * @param secondCollun user password to compare at the database
	 * @return
	 * @throws GenercicException
	 */
	public abstract List<T> buscarItens(int referencia, String secondCollun) throws GenercicException;

	/**
	 * This method get the user id en try to select the user in the server if are mor then one user
	 * with the same id an exeption is throw otherwise it compares the password passe with the one
	 * returne from the server in the case it matches returns true otherwise returns false.
	 *
	 * @param referencia user cod to retriev
	 * @param secondCollun user password to compare at the database
	 * @return
	 * @throws GenercicException
	 */
	public abstract List<T> buscarItens(String referencia, String secondCollun) throws GenercicException;
	
	public abstract Boolean alterarItem(T item) throws GenercicException;
	
	public abstract Boolean alterarItem(Long id, T item) throws GenercicException;
	
	public abstract void excluirItem(T item) throws GenercicException;
	
	public abstract void excluirItem(int id) throws GenercicException;
	
	protected abstract T stringToObject(String objectString) throws GenercicException;

}