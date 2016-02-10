package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import comhs.fundationdev.hairstyle.database.repository.DataBaseCreate;

/**
 * Created by lucas on 08/02/16.
 */
public class PersistencySingleton {
    private static PersistencySingleton instance;
    private static SQLiteDatabase db;

    private static PersistencySingleton getInstance(Context context)
    {
        if(instance == null)
        {
            synchronized (PersistencySingleton.class)
            {
                instance = new PersistencySingleton();

                DataBaseCreate dbCreator = new DataBaseCreate(context);

                db = dbCreator.getDatabase();
            }
        }
        return instance;
    }

    public static SQLiteDatabase getDataBase(Context context)
    {
        if (instance == null)
        {
            PersistencySingleton.getInstance(context);
        }
        return db;
    }

    private PersistencySingleton()
    {

    }
}
