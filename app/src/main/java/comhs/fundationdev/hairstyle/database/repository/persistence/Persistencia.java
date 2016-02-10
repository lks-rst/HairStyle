package comhs.fundationdev.hairstyle.database.repository.persistence;

import java.util.List;

import comhs.fundationdev.hairstyle.exeption.DeleteExeption;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.InsertionExeption;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.exeption.ReadExeption;
import comhs.fundationdev.hairstyle.exeption.UpdateExeption;

/**
 * Created by lucas on 04/02/16.
 */
public interface Persistencia<T>{

	public abstract void inserir(T object)
			throws NotImplementedException, InsertionExeption, GenercicException;

	public abstract List<T> buscarTodos() 
			throws NotImplementedException, ReadExeption, GenercicException;

	public abstract List<T> BuscarItensData(String dataInicail, String dataFinal) 
			throws NotImplementedException, ReadExeption, GenercicException;
	
	public abstract List<T> buscarTodos(String descricao) 
			throws NotImplementedException, ReadExeption, GenercicException;
	
	public abstract T BuscarItem(int id)
			throws NotImplementedException, ReadExeption, GenercicException;
	
	public abstract Boolean alterarItem(T item) 
			throws NotImplementedException, UpdateExeption, GenercicException;
	
	public abstract void ExcluirItem(long id) 
			throws NotImplementedException, DeleteExeption, GenercicException;
}