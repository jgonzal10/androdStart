package co.com.jgo.zazul.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by JGO on 23/11/2016.
 */

public class HelperDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 8;
    public static final String DATABASE_NAME = "semtran.db";

    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(ScriptDB.CREATE_CONFIGURACAO);


        }catch (Exception e){
            Log.d("CREATE PROBLEM", e.getMessage());
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Run when database is upgraded / changed, like drop tables, add tables etc.
        //db.execSQL(ScriptDB.DELETE_DEVICE);
//        db.execSQL("DROP TABLE IF EXISTS " + ScriptDB.BratFotoEntry.TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + ScriptDB.PontoInteresseFotoEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ScriptDB.RemocaoEntry.TABLE_NAME);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}