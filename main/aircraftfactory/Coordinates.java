package aircraftfactory;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    private String weather;

    public Coordinates(int p_longitude, int p_latitude, int p_height){
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }
    
    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getHeight(){
        return this.height;
    }

    public String getWeather(){
        return this.weather;
    }

    public void setLongitude(int l){
        this.longitude = l;
    }
    public void setLatitude(int l){
        this.latitude = l;
    }
    public void setHeight(int h){
        this.height = h;
    }

    public void setWeather(String w){
        this.weather = w;
    }

}
