package co.com.jgo.zazul.activities;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


import butterknife.BindView;
import butterknife.OnClick;
import co.com.jgo.zazul.BuildConfig;
import co.com.jgo.zazul.R;
import co.com.jgo.zazul.controller.ControladorDevice;
import co.com.jgo.zazul.database.LocalDB;
import co.com.jgo.zazul.database.RemoteDB;
import co.com.jgo.zazul.models.Access;
import co.com.jgo.zazul.models.Device;
import co.com.jgo.zazul.models.Usuario;
import co.com.jgo.zazul.parents.BaseActivity;
import co.com.jgo.zazul.utils.KeyboardUtil;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.txt_user)
    EditText txt_user;
    @BindView(R.id.txt_password)
    EditText txt_password;
    @BindView(R.id.pim)
    TextView txt_pim;
    @BindView(R.id.imei)
    TextView txt_imei;
    @BindView(R.id.versao)
    TextView txt_versao;
    @BindView(R.id.log_in_button)
    Button btn_login;

    private ProgressDialog progressDialog;
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATE = 1;
    private static final int PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2;
    private static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 3;
    private static final int PERMISSIONS_REQUEST_LOCATION = 4;

    private ControladorDevice mControladorDevice = ControladorDevice.getInstance(this);
    private String latitude = "", longitude = "";
    public static String sime, spim;
    public static SharedPreferences sp;
  //  private SweetAlertDialog dialogSystem;
    private Device device;
    SharedPreferences prefs;

    private Context mContext;
//    private LocalDB localDB;
//    private RemoteDB remoteDB;
    private String amarra = "";
    private ArrayList<Usuario> UsuList = new ArrayList<Usuario>();
//    private ArrayList<Configuracao> userConf;
    private String LoginUrl, DeviceUrl;
    public static String pwd;
    public static String login;
    public int conn, check;
//    private int codigousuarioentry;

    public static final int progress_bar_type = 0;
    private ProgressDialog pDialog;

    private int downloadatual;
    private Uri fileUri;
    private static final int MEDIA_TYPE_IMAGE = 1;

    @OnClick(R.id.log_in_button)
    void logIn() {

        pwd = txt_password.getText().toString();
        login = txt_user.getText().toString();

        this.prefs = getSharedPreferences("MantarPwd", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = this.prefs.edit();
        e.putString("login", login);
        e.putString("senha", pwd);
        e.commit();

        KeyboardUtil.hideKeyboard(LoginActivity.this);

        int installed = appInstalledOrNot("com.undercode.talonario");
        if(installed==3){
            downloadatual = 2;
            novaVersao("0");
            return;
        }else if(installed==2){

        }

        //btn_login.setEnabled(false);
        Usuario usuario = new Usuario();
        usuario.setlogin(login.trim());
        usuario.setsenha((pwd.trim()));

        //tests of amarra
//        userConf = localDB.return_system_configuration();
        conn = RemoteDB.getConnectivityStatus(getApplicationContext()); //0 sem conexão, 1 wifi, 2 mobile
        Log.d(" conn login activity", conn + "");
        switch (conn) {
            case (0):
                //login offline
                OnAuthenticateOffLine(login, pwd);
                btn_login.setEnabled(true);
                break;
            default:
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Validando o device, aguarde...");
                progressDialog.setTitle("JGO");
                progressDialog.setIndeterminate(true);

                progressDialog.setCancelable(false);
                progressDialog.show();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                onAtheticationDevice();
//                                progressDialog.dismiss();
                            }
                        }, 10
                );


                break;
        }
    }


    // Abstract Methods
    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void getArrayResults(JSONArray response, String option) {

    }

    @Override
    public void getArrayResults(String response, String option) {

    }

    // Controller Code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void defineDevice() {
        if (!CheckReadPhonePermission()) {
            loadDeviceData();
        }

        if (!CheckLocationPermission()) {
            loadGpsData();
        }

        if (!checkPermissionReadStorage())
            return;
        if (!checkPermissionWriteStorage())
            return;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSIONS_REQUEST_READ_PHONE_STATE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadDeviceData();
                    if (!CheckLocationPermission()) {
                        loadGpsData();
                    }
//                    btn_login.setEnabled(true);
                }else{
                    btn_login.setEnabled(false);
                }
                break;
            case PERMISSIONS_REQUEST_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadGpsData();
                    checkPermissionReadStorage();
                    btn_login.setEnabled(true);
                }else{
                    btn_login.setEnabled(false);
                }
                break;
            case PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkPermissionWriteStorage();
                    btn_login.setEnabled(true);
                }else{
                    btn_login.setEnabled(false);
                }
                break;
            case PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btn_login.setEnabled(true);
                }else{
                    btn_login.setEnabled(false);
                }
                break;
        }
    }

    public boolean CheckReadPhonePermission() {

        Context context = getApplicationContext();

        int permissionCheckRead = ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_PHONE_STATE);

        if (permissionCheckRead != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_PHONE_STATE)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        PERMISSIONS_REQUEST_READ_PHONE_STATE);
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        PERMISSIONS_REQUEST_READ_PHONE_STATE);
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean CheckLocationPermission() {

        Context context = getApplicationContext();

        int permissionCheckRead1 = ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION);

        int permissionCheckRead2 = ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permissionCheckRead1 != PackageManager.PERMISSION_GRANTED ||
                permissionCheckRead2 != PackageManager.PERMISSION_GRANTED) {

            Boolean flag1 = ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION);

            Boolean flag2 = ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION);

            if (flag1 || flag2) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_REQUEST_LOCATION);
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_REQUEST_LOCATION);
            }
//            loadDeviceData();
            return true;

        } else {
            return false;
        }
    }

    public boolean checkPermissionReadStorage() {
        Context context = getApplicationContext();

        int permissionCheckRead = ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionCheckRead != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
            return false;

        } else {
            return true;
        }
    }

    public boolean checkPermissionWriteStorage() {
        Context context = getApplicationContext();

        int permissionCheckRead = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheckRead != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
            return false;

        } else {
            return true;
        }
    }


    public void loadDeviceData() {
        device = new Device();
        mControladorDevice.setContext(getApplicationContext());

        // PIM E IMEI
        sime = mControladorDevice.getIMEI();
        spim = mControladorDevice.getPIM();

        device.setIdentification(spim, sime, BuildConfig.VERSION_NAME, "", "", "", "");
        Log.d("spim: ", spim);
        Log.d("sime: ", sime);

        txt_pim.setText("PIM: " + spim);
        txt_imei.setText("IMEI: " + sime);
    }

    private void loadGpsData(){
        // GPS
        mControladorDevice.iniciarGPS1(getApplicationContext());
        mControladorDevice.iniciarGPS2(getApplicationContext());

        Location location = mControladorDevice.getLocation1();
        Location location2 = mControladorDevice.getLocation2();

        if (location != null) {

            try {
                latitude = String.valueOf(location.getLatitude());
                longitude = String.valueOf(location.getLongitude());
            } catch (Exception ex) {
            }
        }

        if (latitude == null)
            latitude = "";
        if (latitude.equals("")) {

            if (location2 != null) {
                try {
                    latitude = String.valueOf(location2.getLatitude());
                    longitude = String.valueOf(location2.getLongitude());
                } catch (Exception ex) {
                }
            }
        }
        if (latitude == null)
            latitude = "";
        if (!latitude.equals("") && !longitude.equals("")) {
            Log.d("latitude: ", latitude);
            Log.d("longitude: ", longitude);
        }


        mControladorDevice.finalizarGPS1();
        mControladorDevice.finalizarGPS2();
        Access a = new Access(latitude, longitude);
    }

    public void avaliarRetorno(String retorno) {

        Log.d("holi", retorno);
    }

    public boolean askForGPS() {

        // verifico se o gps está on
        try {
            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
            // Check if enabled and if not send user to the GPS settings
            if (!enabled) {


            }
        } catch (Exception ex) {

        }
        return true;
    }

    public void onAtheticationDevice() {

        Location location = mControladorDevice.getLocation1();
        Location location2 = mControladorDevice.getLocation2();

        if (location != null) {

            try {
                latitude = String.valueOf(location.getLatitude());
                longitude = String.valueOf(location.getLongitude());
            } catch (Exception ex) {
            }
        }

        if (latitude == null)
            latitude = "";
        if (latitude.equals("")) {

            if (location2 != null) {
                try {
                    latitude = String.valueOf(location2.getLatitude());
                    longitude = String.valueOf(location2.getLongitude());
                } catch (Exception ex) {
                }
            }
        }
        if (latitude == null)
            latitude = "";



    }

    public void onAthetication() {
        Location location = mControladorDevice.getLocation1();
        Location location2 = mControladorDevice.getLocation2();

        if (location != null) {

            try {
                latitude = String.valueOf(location.getLatitude());
                longitude = String.valueOf(location.getLongitude());
            } catch (Exception ex) {
            }
        }

        if (latitude == null || "".equals(latitude)) {

            if (location2 != null) {
                try {
                    latitude = String.valueOf(location2.getLatitude());
                    longitude = String.valueOf(location2.getLongitude());
                } catch (Exception ex) {
                }
            }
        }
        if (latitude == null || "".equals(latitude)) {
            latitude = "0.0";
        }
        if (longitude == null || "".equals(longitude)) {
            longitude = "0.0";
        }


    }

    public void OnAuthenticateOffLine(String login, String senha) {

        if (CheckReadPhonePermission()) {
            return;
        }
        if (CheckLocationPermission()) {
            return;
        }
        if (!checkPermissionReadStorage())
            return;
        if (!checkPermissionWriteStorage())
            return;

        //valido o device
        LocalDB localDB = new LocalDB(this);
        String retorno = "";
        if (spim == null)
            spim = "";
        if (sime == null)
            sime = "";
        if (spim.equals("") || sime.equals(""))
            loadDeviceData();



        String[] rets = retorno.split(";");
        device.setUrlRastreio("");
        device.setUrlInfracao("");
        device.setUrlTabelas("");
        device.setUrlConsultas("");
        try{
            device.setUrlRastreio(rets[1]);
            device.setUrlInfracao(rets[2]);
            device.setUrlTabelas(rets[3]);
            device.setUrlConsultas(rets[4]);
        }catch(Exception ex){}

        //device validado. valido o usuário;

    }

    private void updateUserSharedPreferences(Usuario usuario){
        this.prefs = getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = this.prefs.edit();

        e.putInt("codigo", usuario.getcodigo());
        e.putString("nome", usuario.getnome());
        e.putString("login", usuario.getlogin());
        e.putString("senha", usuario.getsenha());
        e.putString("codigo_orgao", String.valueOf(usuario.getIdOrgao()));
        e.putString("nome_orgao", usuario.getNomeOrgao());
        e.putString("cpf", usuario.getcpf());
        e.putString("matricula", usuario.getmatricula());
        e.putString("perfil", usuario.getPerfil());
        e.putString("grupo", String.valueOf(usuario.getid_grupo()));
        e.putString("segmento", usuario.getSegmento());
        e.putString("uf", usuario.getUf());
        e.putString("codigo_municipio", String.valueOf(usuario.getId_cidade()));
        e.putString("nome_municipio", usuario.getNomeCidade());
        e.putString("endereco", usuario.getendereco());
        e.putString("complemento", usuario.getcomplemento());
        e.putString("cep", usuario.getcep());
        e.putInt("codigo_orgao", usuario.getIdOrgao());
        e.putString("nome_orgao", usuario.getNomeOrgao());

//        e.putString("foto", usuario.getfoto());
        e.putInt("id_cidade", usuario.getId_cidade());
//        e.putString("email", .getString("email"));

        e.putInt("id_grupo", usuario.getid_grupo());
        e.putString("id_perfil", usuario.getPerfil());
        e.putString("segmento", usuario.getSegmento());
        e.putString("uf", usuario.getUf());
        e.putInt("codigo_municipio", usuario.getId_cidade());
        e.putString("nome_municipio", usuario.getNomeCidade());
        e.putString("modulos", usuario.getmodulos());
        e.putString("data_atualizacao", usuario.getDataAtualizacao());

        e.putString("url_rastreio", device.geturlrastreio());
        e.putString("url_consultas", device.geturlconsultas());
        e.putString("url_infracao", device.geturlinfracao());
        e.putString("url_tabelas", device.geturltabelas());


        e.apply();
    }

    public void novaVersao(String opt) {
        if (opt.equals("0")) {
            downloadatual = 2;
            new DownloadFileFromURL().execute("http://www.level33.com.br/zonaazul/talonario.apk");
        }else if (opt.equals("1")) {
            downloadatual = 1;
            new DownloadFileFromURL().execute("http://www.level33.com.br/zonaazul/zonaazul.apk");
        } else if (opt.equals("2")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String realPath = fileUri.getPath();
            if(downloadatual==2)
                realPath = realPath.replace("zonaazul.apk", "talonario.apk");
            intent.setDataAndType(Uri.fromFile(new File(realPath)),
                    "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    // @SuppressLint("InlinedApi")
    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                // Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "zonaazul.apk");
        } else {
            return null;
        }

        return mediaFile;
    }

    private int appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        int app_installed;
        try {
            PackageInfo pki = pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            int vck = pki.versionCode;
            //if(vck==17)
            app_installed = 1;
            //else
            //    app_installed = 2;
            //pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);

        } catch (PackageManager.NameNotFoundException e) {
            app_installed = 3;
        }
        return app_installed;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                pDialog = new ProgressDialog(this);
                if(downloadatual==1)
                    pDialog.setMessage("Baixando nova versão. Por favor, aguarde...");
                else
                    pDialog.setMessage("O talonário não está instalado. Baixando o talonário. Por favor, aguarde...");
                pDialog.setIndeterminate(false);
                pDialog.setMax(100);
                pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pDialog.setCancelable(true);
                pDialog.show();
                return pDialog;
            default:
                return null;
        }
    }

    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file length
                int lenghtOfFile = conection.getContentLength();

                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);
                String realPath = fileUri.getPath();
                if(downloadatual==2)
                    realPath = realPath.replace("zonaazul.apk","talonario.apk");
                File myFile = new File(realPath);
                if (myFile.exists()) {
                    myFile.delete();
                }
                myFile.createNewFile();
                // FileOutputStream fOut = new FileOutputStream(myFile);
                // Output stream to write file
                OutputStream output = new FileOutputStream(myFile);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

                novaVersao("2");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);


        }

    }

}
