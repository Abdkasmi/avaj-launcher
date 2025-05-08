import aircraftfactory.Tower;
import aircraftfactory.WeatherTower;
import aircraftfactory.Flyable;
import aircraftfactory.Coordinates;
import aircraftfactory.Baloon;
import aircraftfactory.JetPlane;
import aircraftfactory.Helicopter;
import aircraftfactory.AircraftFactory;

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
// import java.lang.NumberFormatException;
import custom_exception.ParseFileErrorException;

public class main {

    private static boolean isAlpha(String[] data) {
        for (int n = 2; n <= 4; n++) {
            for (int m = 0; m < data[n].length(); m++) {
                if ((data[n].charAt(m) >= 'a' && data[n].charAt(m) <= 'z') ||
                    (data[n].charAt(m) >= 'A' && data[n].charAt(m) <= 'Z')) {
                   return true;   
                }
            }
        }
        return false;
    }

    private static List<List<String>> check_scenario(Scanner reader) {
        String data = "";
        String[] temp_data;
        List<List<String>> parsed_data = new ArrayList<List<String>>();
        int i = 0;

        try {
            while (reader.hasNextLine()) {
                parsed_data.add(new ArrayList<String>());
                data = reader.nextLine();
                temp_data = data.split(" ");
                if (temp_data.length != 5) {
                    throw new ParseFileErrorException("Format each line like this please: TYPE NAME LONGITUDE LATITUDE HEIGHT");
                }
                if (isAlpha(temp_data)) {
                    throw new ParseFileErrorException("Coordinates must contain only numbers");   
                }
                if (!temp_data[0].equals("Baloon") && !temp_data[0].equals("JetPlane") && !temp_data[0].equals("Helicopter")){
                    throw new ParseFileErrorException(temp_data[0] + " is not a valid Type");
                }
                if ((Integer.valueOf(temp_data[2]) < 0 || Integer.valueOf(temp_data[3]) < 0 || Integer.valueOf(temp_data[4]) < 0)) {
                    throw new ParseFileErrorException("Coordinates must be positive values");
                }
                if (Integer.valueOf(temp_data[4]) > 100) {
                    throw new ParseFileErrorException("Height must be in 0-100 range");
                }
                for (int j = 0; j < temp_data.length; j++) {
                    parsed_data.get(i).add(temp_data[j]);
                }
                i++;
            }
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        
        return parsed_data;
    }

    private static void parse_scenario(List<List<String>> parsed_scenario, WeatherTower tower) {
        AircraftFactory factory = AircraftFactory.getInstance();
        for (List<String> scenario: parsed_scenario) {
            for (String item: scenario) {
                if (item.equals("Baloon")) {
                    if (Integer.valueOf(scenario.get(4)) > 100) {
                        scenario.set(4, "100");
                    }
                    Coordinates coordinates = new Coordinates(Integer.valueOf(scenario.get(2)),
                         Integer.valueOf(scenario.get(3)), Integer.valueOf(scenario.get(4)));
                    Flyable baloon = factory.newAircraft("Baloon", scenario.get(1), coordinates);
                    tower.register(baloon);
                    break ;
                }
                else if (item.equals("JetPlane")) {
                    if (Integer.valueOf(scenario.get(4)) > 100) {
                        scenario.set(4, "100");
                    }
                    Coordinates coordinates = new Coordinates(Integer.valueOf(scenario.get(2)),
                         Integer.valueOf(scenario.get(3)), Integer.valueOf(scenario.get(4)));
                    Flyable jetPlane = factory.newAircraft("JetPlane", scenario.get(1), coordinates);
                    tower.register(jetPlane);
                    break ;
                }
                else if (item.equals("Helicopter")) {
                    if (Integer.valueOf(scenario.get(4)) > 100) {
                        scenario.set(4, "100");
                    }
                    Coordinates coordinates = new Coordinates(Integer.valueOf(scenario.get(2)),
                         Integer.valueOf(scenario.get(3)), Integer.valueOf(scenario.get(4)));
                    Flyable helicopter = factory.newAircraft("Helicopter", scenario.get(1), coordinates);
                    tower.register(helicopter);
                    break ;
                }
                else {
                    System.err.printf("%s is not a valid Aircraft type\n", item);
                }
            }
        }
    }

    private static void simulation(int weather_change, WeatherTower tower) {
        List<Flyable> observers = tower.getObservers();
        int i = weather_change;

        while (i > 0) {
            tower.changeWeather();
            if (observers.size() == 0) {
                System.out.println("All Aircraft Landed successfuly");
                break;
            }
            i--;
        } 
        System.out.printf("Weather scenario count: %d left && tower size: %d", i, observers.size());
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                File scenario = new File(args[0]);
                Scanner reader = new Scanner(scenario);
                File simulation = new File("simulation.txt");
                if (!simulation.createNewFile()) {
                    PrintWriter content = new PrintWriter(simulation);
                    content.close();
                }
                PrintStream o = new PrintStream(simulation);
                PrintStream console = System.out;
                System.setOut(o);
                int weather_change = 0;
                try {
                    weather_change = Integer.valueOf(reader.nextLine()); // handle case where first line is not an Integer
                } catch (Exception e) {
                    System.err.println("First line should be an integer");
                    System.setOut(console);
                    System.exit(1);
                }
                List<List<String>> parsed_scenario = check_scenario(reader);
                WeatherTower tower = new WeatherTower();

                parse_scenario(parsed_scenario, tower);
                simulation(weather_change, tower);
                System.setOut(console);
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("An error has occured while executing the program");
            }
        }
        else {
            System.err.println("Please enter only one argument");
        }
    }
}