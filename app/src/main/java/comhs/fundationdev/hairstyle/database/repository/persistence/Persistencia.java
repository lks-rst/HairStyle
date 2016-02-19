package comhs.fundationdev.hairstyle.database.repository.persistence;

import java.util.List;

import comhs.fundationdev.hairstyle.exeption.GenercicException;

/**
 * Created by lucas on 04/02/16.
 */
public interface Persistencia<T>{

	public abstract void inserir(T object) throws GenercicException;

	public abstract void inserir(String strObject) throws GenercicException;

	public abstract List<T> buscarTodos() throws GenercicException;

	public abstract List<T> buscarItensData(String dataInicail, String dataFinal) throws GenercicException;

	public abstract List<T> buscarTodos(String descricao) throws GenercicException;

	public abstract List<String> buscarString() throws GenercicException;

	public abstract T buscarItem(String referencia) throws GenercicException;

	public abstract T buscarItem(int referencia, String secondCollun) throws GenercicException;

	public abstract T buscarItem(String referencia, String secondCollun) throws GenercicException;

	public abstract List<T> buscarItens(String referencia, String secondCollun) throws GenercicException;

	public abstract Boolean alterarItem(T item) throws GenercicException;

	public abstract Boolean alterarItem(Long id, T item) throws GenercicException;

	public abstract void excluirItem(T item) throws GenercicException;

	public abstract void excluirItem(int id) throws GenercicException;

}