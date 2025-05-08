package aircraftfactory;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public String getType() {
        return "Baloon";
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void updateConditions(){
        switch (this.coordinates.getWeather()){
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 5);
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
        }
    }

}