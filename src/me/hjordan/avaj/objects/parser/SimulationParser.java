package me.hjordan.avaj.objects.parser;

import me.hjordan.avaj.AvajLauncher;
import me.hjordan.avaj.objects.aircrafts.Flyable;
import me.hjordan.avaj.objects.exceptions.ParsingException;
import me.hjordan.avaj.objects.towers.impl.WeatherTower;

import javax.swing.text.ParagraphView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static me.hjordan.avaj.utils.Const.*;

public class SimulationParser {

    private String simulationPath;
    private int simulationCount;
    private List<String> lines;

    public SimulationParser(String simulationPath) {
        this.simulationPath = simulationPath;
        this.simulationCount = 0;
        this.lines = new ArrayList<>();
    }

    public void parse(WeatherTower tower) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(this.simulationPath));
        String line = null;

        for (int count = 0; (line = reader.readLine()) != null; count++) {
            if (count == 0) {
                this.simulationCount = Integer.parseInt(line);

                if (this.simulationCount < MIN_SIMULATION_AMOUNT)
                    throw new ParsingException("Invalid simulation count: " + this.simulationCount);
                continue;
            }
            this.lines.add(line);
        }

        this.lines.forEach(current -> {
            String[] split = current.split(" ");

            if (split.length != REQUIRED_FIELD_COUNT)
                throw new IllegalArgumentException("Invalid line format: " + current);

            final String type = split[0];
            final String name = split[1];
            final int longitude = Integer.parseInt(split[2]);
            final int latitude = Integer.parseInt(split[3]);
            final int height = Integer.parseInt(split[4]);

            final Flyable flyable = AvajLauncher.FACTORY.newAircraft(type, name, longitude, latitude, height);

            if (flyable == null)
                throw new IllegalArgumentException("Invalid aircraft type: " + type);

            tower.register(flyable);
        });

        reader.close();
    }

    public int getSimulationCount() {
        return this.simulationCount;
    }
}
