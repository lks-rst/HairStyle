package comhs.fundationdev.hairstyle.database.repository.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import comhs.fundationdev.hairstyle.R;
import comhs.fundationdev.hairstyle.database.repository.DataBaseCreate;

public class PersistencySingleton {
    private static Connection conn;
    private static SQLiteDatabase db;
    private static PersistencySingleton instance;

    private static PersistencySingleton getInstance(Context context) {
        if (instance == null) {
            synchronized (PersistencySingleton.class) {
                instance = new PersistencySingleton();
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                }
                SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.preference_file), 0);
                String user = context.getResources().getString(R.string.preference_user_default);
                String ip = context.getResources().getString(R.string.preference_server_default);
                String password = context.getResources().getString(R.string.preference_pswd_default);
                String dbName = context.getResources().getString(R.string.preference_base_default);
                String user2 = preferences.getString(context.getString(R.string.preference_user), user);
                String ip2 = preferences.getString(context.getString(R.string.preference_server), ip);
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://" + ip2 + "/" + preferences.getString(context.getString(R.string.preference_base), dbName) + "", user2, preferences.getString(context.getString(R.string.preference_pswd), password));
                } catch (SQLException e4) {
                    e4.printStackTrace();
                }
                db = new DataBaseCreate(context).getDatabase();
            }
        }
        return instance;
    }

    public static SQLiteDatabase getDataBase(Context context) {
        if (instance == null) {
            getInstance(context);
        }
        return db;
    }

    public static Connection getMyDataBase(Context context) {
        if (instance == null) {
            getInstance(context);
        }
        return conn;
    }

    private PersistencySingleton() {
    }
}
