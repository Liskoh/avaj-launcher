package me.hjordan.avaj;

import me.hjordan.avaj.objects.AircraftFactory;
import me.hjordan.avaj.objects.parser.SimulationParser;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import java.io.IOException;

public class AvajLauncher {

    public static final AircraftFactory FACTORY = new AircraftFactory();
    private static final WeatherTower TOWER = new WeatherTower();

    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException("Invalid number of arguments passed to program." +
                    "Please pass a single argument, the path to the simulation file.");

        final String simulationPath = args[0];
        final SimulationParser parser = new SimulationParser(simulationPath);

        try {
            parser.parse(TOWER);

            // Run the simulation
            for (int i = 0; i < parser.getSimulationCount(); i++)
                TOWER.changeWeather();

        } catch (IOException e) {
            System.out.println("Error parsing simulation file: " + e.getMessage());
            System.exit(1);
        }
    }
}