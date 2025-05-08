package aircraftfactory;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }

    public String getType() {
        return "JetPlane";
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
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
    }

}