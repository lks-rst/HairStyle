package comhs.fundationdev.hairstyle.database.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import comhs.fundationdev.hairstyle.database.repository.tabelas.UserTable;

/**
 * Created by lucas on 04/02/16.
 */
public class Banco extends SQLiteOpenHelper{

    private List<String> insertScript;
    private List<String> scriptSQLCreate;
    private static final String DB_NAME = "hair.db";
    private static final int DB_VERSION = 1;


    public Banco(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        this.scriptSQLCreate = new ArrayList<String>();
        this.scriptSQLCreate.add(UserTable.criaTabela());
        //this.insertScript[0] = scriptSQLCreate;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        // CriaÃ§Ã£o das tabelas do DB.
        for (String script : scriptSQLCreate)
        {
            db.execSQL(script);
        }

        // InserÃ§Ã£o dos registros principais.
       /* for (String insert : insertScript)
        {
            db.execSQL(insert);
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
