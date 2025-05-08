package aircraftfactory;

// Singleton Class
public class WeatherProvider {
    private String[] weather;
    private static WeatherProvider instance = null;

    private WeatherProvider() {
        this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        switch (p_coordinates.getWeather()){
            case "RAIN":
                return "RAIN";
            case "FOG":
                return "FOG";
            case "SUN":
                return "SUN";
            case "SNOW":
                return "SNOW";
            default:
                return "";
        }
    }

}
