package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import comhs.fundationdev.hairstyle.exeption.DeleteExeption;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.InsertionExeption;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.exeption.ReadExeption;
import comhs.fundationdev.hairstyle.exeption.UpdateExeption;
import comhs.fundationdev.hairstyle.negocio.objects.Servico;

/**
 * Created by lucas on 11/02/16.
 */
public class ServicePersistency implements Persistencia<Servico> {
    private SQLiteDatabase db;
    private Context ctx;
    private String sql;
    private StringBuilder sBuilder;
    private Cursor c;

    public ServicePersistency(SQLiteDatabase db, Context context)
    {
        this.db = db;
        this.ctx = context;
        this.sBuilder = new StringBuilder();
    }

    @Override
    public void inserir(Servico object) throws NotImplementedException, InsertionExeption, GenercicException {

    }

    @Override
    public List<Servico> buscarTodos() throws NotImplementedException, ReadExeption, GenercicException {
        return null;
    }

    @Override
    public List<Servico> BuscarItensData(String dataInicail, String dataFinal) throws NotImplementedException, ReadExeption, GenercicException {
        return null;
    }

    @Override
    public List<Servico> buscarTodos(String descricao) throws NotImplementedException, ReadExeption, GenercicException {
        return null;
    }

    @Override
    public Servico BuscarItem(int id) throws NotImplementedException, ReadExeption, GenercicException {
        return null;
    }

    @Override
    public Boolean alterarItem(Servico item) throws NotImplementedException, UpdateExeption, GenercicException {
        return null;
    }

    @Override
    public void ExcluirItem(long id) throws NotImplementedException, DeleteExeption, GenercicException {

    }
}
