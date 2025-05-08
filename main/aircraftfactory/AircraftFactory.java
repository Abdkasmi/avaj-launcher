package aircraftfactory;

import java.util.UUID;

// Singleton Class

public class AircraftFactory {

    private static AircraftFactory factory = null;

    public static AircraftFactory getInstance() {
        if (factory == null) {
            factory = new AircraftFactory();
        }
        return factory;

    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (p_type.equals("Baloon")){
            long uniqueID = Math.abs(UUID.randomUUID().getMostSignificantBits());
            Flyable baloon = new Baloon(uniqueID, p_name, p_coordinates);
            return baloon;
        }
        if (p_type.equals("JetPlane")){
            long uniqueID = Math.abs(UUID.randomUUID().getMostSignificantBits());
            Flyable jetPlane = new JetPlane(uniqueID, p_name, p_coordinates);
            return jetPlane;
        }
        if (p_type.equals("Helicopter")){
            long uniqueID = Math.abs(UUID.randomUUID().getMostSignificantBits());
            Flyable helicopter = new Helicopter(uniqueID, p_name, p_coordinates);
            return helicopter;
        }
        return null;
    }

}