package zm.hashcode.pvtdroid.repository.Impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import zm.hashcode.pvtdroid.domain.Person;
import zm.hashcode.pvtdroid.repository.PersonRespository;

/**
 * Created by hashcode on 2016/04/05.
 */
public class PersonRespositoryImpl extends SQLiteOpenHelper implements PersonRespository{
    public static final String TABLE_PERSON="person";


//    private String org;
//    private String id;
//    private String firstName;
//    private String emailAddress;
//    private String lastName;
//    private String authvalue

    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_ORG ="org";
    public static final String COLUMN_FIRSTNAME="firstName";
    public static final String COLUMN_EMAIL ="emailAddress";
    public static final String COLUMN_LASTNAME ="lastName";
    public static final String COLUMN_AUTHVALUE ="authvalue";


    public PersonRespositoryImpl(Context context, String name,  int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void create(Person person) {

    }

    @Override
    public Person findById(String id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }


}
