package co.com.jgo.zazul.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import co.com.jgo.zazul.models.Device;
import co.com.jgo.zazul.models.Modulo;
import co.com.jgo.zazul.models.Perfil;
import co.com.jgo.zazul.models.Perfil_Modulo;
import co.com.jgo.zazul.models.Usuario;
import co.com.jgo.zazul.parents.controllerDB;


public class LocalDB extends controllerDB {

    private static Context appContext;
    protected SQLiteDatabase db;
    private HelperDB helperDB;
    private static LocalDB localDB;
    private static Cursor cursor;
    Usuario usuario;
    private int codigo_EUD = 1, codigo_VBC = 1, codigo_Vitima = 1;
    private static ArrayList<Usuario> UsuList = new ArrayList<Usuario>();
    private static ArrayList<Modulo> ModList = new ArrayList<Modulo>();
    private static ArrayList<Perfil> PerList = new ArrayList<Perfil>();
    private static ArrayList<Perfil_Modulo> PerModList = new ArrayList<Perfil_Modulo>();
    public static int id_perfil_usuario, codigo_usuario;


    public LocalDB(Context context) {
        super(context);

        appContext = context;
        helperDB = new HelperDB(appContext);
    }

    public HelperDB getHelperDB() {
        return this.helperDB;
    }

    public String validaDevice(String pim, String imei) {
        db = helperDB.getReadableDatabase();

        String retorno = "0";
        String query = SELECT + "url_rastreio,url_infracao,url_tabelas,url_consultas"
                + FROM + ScriptDB.DeviceEntry.TABLE_NAME + WHERE + "pim='" + encripta(pim) + "'" + AND + "imei='" + encripta(imei) + "'";
        //query ainda nao termino
        Cursor cursor = this.db.rawQuery(query, null);


        try {
            if (cursor.moveToFirst())
                retorno = "tem;" + cursor.getString(0) + ";"
                        + cursor.getString(1) + ";" + cursor.getString(2) + ";"
                        + cursor.getString(3) + ";";
        } catch (Exception ex) {
        }
        if (cursor != null && !cursor.isClosed())
            cursor.close();

        return retorno;
    }

    public boolean insertDevice(Device device) {
        db = helperDB.getReadableDatabase();
        boolean flag = true;
        String query = "";
        String ret="";
        query = "select '1' from device where pim='" + encripta(device.getpim()) + "'";
        query += " and imei='" + encripta(device.getimei()) + "'";
        ret = retornaString(query);
        if(ret.equals("")) {
            query = INSERT_INTO + ScriptDB.DeviceEntry.TABLE_NAME
                    + VALUES + "('" + encripta(device.getpim()) + "', '" + encripta(device.getimei()) + "','" + encripta(device.getversao()) + "'," +
                    "'" + device.geturlrastreio() + "','" + device.geturlinfracao() +"','"+ device.geturltabelas() + "','" + device.geturlconsultas() + "')";
            try {
                db.execSQL(query);
            } catch (Exception ex) {
                flag = false;
            }
        }

        return flag;
    }

    public String retornaString(String query) {
        String retorno = "";
        Cursor cursor = this.db.rawQuery(query, null);
        try {
            if (cursor.moveToFirst())
                retorno = cursor.getString(0);
        } catch (Exception ex) {
        }
        if (cursor != null && !cursor.isClosed())
            cursor.close();

        return retorno;
    }


}
