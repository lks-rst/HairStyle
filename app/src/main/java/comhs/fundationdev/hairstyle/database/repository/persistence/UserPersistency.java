package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.tabelas.UserTable;
import comhs.fundationdev.hairstyle.exeption.DeleteExeption;
import comhs.fundationdev.hairstyle.exeption.GenercicException;
import comhs.fundationdev.hairstyle.exeption.InsertionExeption;
import comhs.fundationdev.hairstyle.exeption.NotImplementedException;
import comhs.fundationdev.hairstyle.exeption.ReadExeption;
import comhs.fundationdev.hairstyle.exeption.UnsuportedOperationExeption;
import comhs.fundationdev.hairstyle.exeption.UpdateExeption;
import comhs.fundationdev.hairstyle.negocio.objects.User;

/**
 * Created by lucas on 04/02/16.
 */
public class UserPersistency implements Persistencia<User> {

    private SQLiteDatabase db;
    private Context ctx;
    private String sql;
    private StringBuilder sBuilder;
    private Cursor c;

    public UserPersistency(SQLiteDatabase db, Context context)
    {
        this.db = db;
        this.ctx = context;
        this.sBuilder = new StringBuilder();
    }

    @Override
    public void inserir(User object) throws NotImplementedException, InsertionExeption, GenercicException {
        ContentValues values = new ContentValues();
        values.put(UserTable.COD, object.getId());
        values.put(UserTable.USER, object.getNome());
        values.put(UserTable.PSWD, object.getPswd());
/*
        sBuilder.delete(0, sBuilder.length());
        sBuilder.append("insert into ");
        sBuilder.append(UserTable.NOME_TABELA);
        sBuilder.append("(");
        sBuilder.append(UserTable.COD);
        sBuilder.append(",");
        sBuilder.append(UserTable.USER);
        sBuilder.append(",");
        sBuilder.append(UserTable.PSWD);
        sBuilder.append(") values ( ");
        sBuilder.append(object.getId());
        sBuilder.append(",");
        sBuilder.append(object.getNome());
        sBuilder.append(",");
        sBuilder.append(object.getPswd());
        sBuilder.append(");");

        String sql = sBuilder.toString();

        db.execSQL(sql);
    */
        db.insertOrThrow(UserTable.NOME_TABELA, "", values);
    }

    @Override
    public List<User> buscarTodos() throws NotImplementedException, ReadExeption, GenercicException {
        sBuilder.delete(0, sBuilder.length());
        sBuilder.append("Select * from ");
        sBuilder.append(UserTable.NOME_TABELA);

        sql = sBuilder.substring(0);

        c = db.rawQuery(sql, null);

        if (c.getCount() > 0){
            List<User> lista = new ArrayList<User>();
            c.moveToFirst();

            for (int i = 0; i < c.getCount(); i++){
                User usr = new User();
                usr.setId(c.getInt(c.getColumnIndex(UserTable.COD)));
                usr.setNome(c.getString(c.getColumnIndex(UserTable.USER)));
                usr.setPswd(c.getString(c.getColumnIndex(UserTable.PSWD)));

                lista.add(usr);

                c.moveToNext();
            }

            c.close();

            return lista;
        } else {
            throw new ReadExeption(ctx.getResources().getString(R.string.read_exeption));
        }
    }

    @Override
    public List<User> BuscarItensData(String dataInicail, String dataFinal)
            throws NotImplementedException, ReadExeption, GenercicException {
        throw new UnsuportedOperationExeption(
                ctx.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public List<User> buscarTodos(String descricao)
            throws NotImplementedException, ReadExeption, GenercicException {
        throw new UnsuportedOperationExeption(
                ctx.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public User BuscarItem(int id) throws NotImplementedException, ReadExeption, GenercicException {
        sBuilder.delete(0, sBuilder.length());
        sBuilder.append("Select * from ");
        sBuilder.append(UserTable.NOME_TABELA);
        sBuilder.append(" where ");
        sBuilder.append(UserTable.COD);
        sBuilder.append(" = ");
        sBuilder.append(id);

        sql = sBuilder.substring(0);

        c = db.rawQuery(sql, null);

        if (c.getCount() > 0){
            c.moveToFirst();

            User u = new User();
            u.setId(c.getInt(c.getColumnIndex(UserTable.COD)));
            u.setNome(c.getString(c.getColumnIndex(UserTable.USER)));
            u.setPswd(c.getString(c.getColumnIndex(UserTable.PSWD)));

            c.close();

            return u;

        } else {
            throw new ReadExeption(ctx.getResources().getString(R.string.read_exeption));
        }
    }

    @Override
    public Boolean alterarItem(User item) throws NotImplementedException, UpdateExeption, GenercicException {
        throw new UnsuportedOperationExeption(
                ctx.getResources().getString(R.string.usuported_exception));
    }

    @Override
    public void ExcluirItem(long id) throws NotImplementedException, DeleteExeption, GenercicException {
        sBuilder.delete(0, sBuilder.length());
        sBuilder.append("delete from ");
        sBuilder.append(UserTable.NOME_TABELA);
        sBuilder.append(" where ");
        sBuilder.append(UserTable.COD);
        sBuilder.append(" = ");
        sBuilder.append(id);

        sql = sBuilder.substring(0);

        try
        {
            db.execSQL(sql);
        } catch (Exception e)
        {
            throw new DeleteExeption(
                    ctx.getResources().getString(R.string.delete_exeption));
        }
    }
}
