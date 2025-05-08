package aircraftfactory;

import java.util.List;
import java.util.Random;


public class WeatherTower extends Tower {

    private void setRain(Flyable obs) {
         try {
            if (!obs.getCoordinates().getWeather().equals("RAIN")) {
                obs.getCoordinates().setWeather("RAIN");
                obs.updateConditions();
            } else {
                System.out.printf("%s#%s(%d): Let's go for an other shower !\n",  obs.getType(), obs.getName(), obs.getId());
            }
        } catch (Exception e){
            obs.getCoordinates().setWeather("RAIN");
        }
    }

    private void setFog(Flyable obs) {
        try {
            if (!obs.getCoordinates().getWeather().equals("FOG")) {
                obs.getCoordinates().setWeather("FOG");
                obs.updateConditions();
            } else {
                System.out.printf("%s#%s(%d): Be careful clouds are still doing as they want !\n", obs.getType(), obs.getName(), obs.getId());
            }
        } catch (Exception e){
            obs.getCoordinates().setWeather("FOG");
        }
    } 

    private void setSun(Flyable obs) {
        try {
            if (!obs.getCoordinates().getWeather().equals("SUN")) {
                obs.getCoordinates().setWeather("SUN");
                obs.updateConditions();
            } else {
                System.out.printf("%s#%s(%d): Still sunny here !\n",  obs.getType(), obs.getName(), obs.getId());
            }
        } catch (Exception e){
            obs.getCoordinates().setWeather("SUN");
        }
    }

    private void setSnow(Flyable obs) {
        try {
            if (!obs.getCoordinates().getWeather().equals("SNOW")) {
                obs.getCoordinates().setWeather("SNOW");
                obs.updateConditions();
            } else {
                System.out.printf("%s#%s(%d): Snow doesn't stop for now !\n",  obs.getType(), obs.getName(), obs.getId());
            }
        } catch (Exception e){
            obs.getCoordinates().setWeather("SNOW");
        }
    }

    private void generateWeather(Flyable obs) {
        Random random = new Random();

        int randomWeather = random.nextInt(4) + 1;
        switch (randomWeather) {
            case 1:
                setRain(obs);
                break;
            case 2:
                setFog(obs);
                break;
            case 3:
                setSun(obs);
                break;
            case 4:
                setSnow(obs);
                break;
        }
    }

    public String getWeather(Coordinates p_coordinates){
        WeatherProvider provider = WeatherProvider.getInstance();
        return provider.getCurrentWeather(p_coordinates);
    }
    public void changeWeather(){
        List<Flyable> observers = this.getObservers();

        for (Flyable obs: observers) {
            generateWeather(obs);
            if (obs.getCoordinates().getHeight() <= 0) {
                this.unregister(obs);
                break ;
            }
        }
        // this.conditionChanged();
    }

}