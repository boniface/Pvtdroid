package zm.hashcode.pvtdroid.repository.Impl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import zm.hashcode.pvtdroid.domain.Settings;
import zm.hashcode.pvtdroid.repository.SettingsRespository;

/**
 * Created by hashcode on 2016/04/05.
 */
public class SettingsRespositoryImpl extends SQLiteOpenHelper implements SettingsRespository{
    public static final String TABLE_SETTINGS="settings";
    public static final String DATABASE_NAME="pvtdroid";
    public static final int DATABASE_VERSION=1;
    private SQLiteDatabase db;

    private String orgId;
    private String emailAddress;
    private String password;

    public static final String COLUMN_ORGID ="orgId";
    public static final String COLUMN_EMAIL_ADDRESS ="emailaddress";
    public static final String COLUMN_PASSWORD="passwd";

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_SETTINGS + "("
            + COLUMN_ORGID + " text primary key, "
            + COLUMN_EMAIL_ADDRESS + " text not null, "
            + COLUMN_PASSWORD + " text not null);";


    public SettingsRespositoryImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
        onCreate(db);

    }

    @Override
    public void create(Settings settings) {

    }

    @Override
    public Settings findById(String id) {
        return null;
    }

    @Override
    public void update(Settings settings) {

    }

    @Override
    public void delete(Settings settings) {

    }
}
