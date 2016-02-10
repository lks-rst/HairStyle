package comhs.fundationdev.hairstyle.database.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lucas on 08/02/16.
 */
public class DataBaseCreate {
    private SQLiteDatabase database;

    private Banco sqlHelperDb;

    /**
     * versão banco de produção.
     */
    public static final int TUTORIAL_DB_VERSION = 1;

    /**
     * nome banco de cache.
     */
    public static final String VENDAS_DB = "hair.db";

    public DataBaseCreate(Context context) {

        // cria o esquema e popula a base de dados de cache.
        sqlHelperDb = new Banco(context);
    }

    public SQLiteDatabase getDatabase()
    {
        // deixa a base de dados de produção em modo de leitura.
        database = sqlHelperDb.getWritableDatabase();
        return database;
    }

    /**
     * fecha conexÃ£o.
     */
    public void closed() {
        if (sqlHelperDb != null) {
            sqlHelperDb.close();
            database.close();
        }
    }
}
