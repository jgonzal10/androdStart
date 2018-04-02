package co.com.jgo.zazul.models;



public class Access {

    private int codigo;
    private String data_on;
    private String data_off;
    private String longitude;
    private String latitude;

    public Access(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // GET'S
    public int getcodigo() {
        return this.codigo;
    }
    public String getdata_on() { return this.data_on; }
    public String getdata_off() { return this.data_off; }
    public String getlongitude() { return this.longitude; }
    public String getlatitude() {
        return this.latitude;
    }

    // SET'S
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setdata_on(String data_on) {
        this.data_on = data_on;
    }
    public void setdata_off(String data_off) {
        this.data_off = data_off;
    }
    public void setlongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setlatitude(String latitude) {
        this.latitude = latitude;
    }

}