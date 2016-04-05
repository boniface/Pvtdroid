package zm.hashcode.pvtdroid.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import zm.hashcode.pvtdroid.domain.Settings;
import zm.hashcode.pvtdroid.repository.SettingsRespository;

/**
 * Created by hashcode on 2016/04/05.
 */
public class SettingsRespositoryImpl extends SQLiteOpenHelper implements SettingsRespository {
    public static final String TABLE_SETTINGS = "settings";
    public static final String DATABASE_NAME = "pvtdroid";
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    private String orgId;
    private String emailAddress;
    private String password;

    public static final String COLUMN_ORGID = "orgId";
    public static final String COLUMN_EMAIL_ADDRESS = "emailaddress";
    public static final String COLUMN_PASSWORD = "passwd";

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
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ORGID, settings.getOrgId());
        values.put(COLUMN_EMAIL_ADDRESS, settings.getEmailAddress());
        values.put(COLUMN_PASSWORD, settings.getPassword());
        db.insert(TABLE_SETTINGS, null, values);

    }

    @Override
    public Settings findById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_SETTINGS,
                new String[]{COLUMN_ORGID,COLUMN_EMAIL_ADDRESS,COLUMN_PASSWORD},
                COLUMN_ORGID + " =?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor!=null)
            cursor.moveToFirst();

        Settings settings = new Settings();
        settings.setOrgId(cursor.getString(0));
        settings.setEmailAddress(cursor.getString(1));
        settings.setPassword(cursor.getString(2));
        
        return settings;
    }

    @Override
    public void update(Settings settings) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL_ADDRESS, settings.getEmailAddress());
        values.put(COLUMN_PASSWORD, settings.getPassword());
        //Table name, to update the values value, the where clause, the where clause? String corresponding parameter placeholders
        db.update(
                TABLE_SETTINGS,
                values, COLUMN_ORGID + "=?",
                new String[]{String.valueOf(settings.getOrgId())}
        );
    }
    @Override
    public void delete(Settings settings) {
        db.delete(
                TABLE_SETTINGS,
                COLUMN_PASSWORD + "=?",
                new String[]{String.valueOf(settings.getOrgId())});

    }
}
