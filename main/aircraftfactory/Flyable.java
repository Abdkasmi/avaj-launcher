package aircraftfactory;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public void registerTower(WeatherTower p_tower){}

    public abstract void updateConditions();
    
    public abstract String getName();
    public abstract long getId();
    public abstract String getType();
    public abstract Coordinates getCoordinates();

}