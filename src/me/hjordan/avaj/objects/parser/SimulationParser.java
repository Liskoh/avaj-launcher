package me.hjordan.avaj.objects.parser;

import java.io.BufferedReader;
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

    public void parse() throws IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(this.simulationPath));
        String line = null;

        for (int count = 0; (line = reader.readLine()) != null; count++) {
            if (count == 0) {
                this.simulationCount = Integer.parseInt(line);

                if (this.simulationCount < MIN_SIMULATION_AMOUNT)
                    throw new NumberFormatException("Invalid simulation count: " + this.simulationCount);
                continue;
            }
            this.lines.add(line);
        }

        this.lines.forEach(current -> {
            String[] split = current.split(" ");

            if (split.length != REQUIRED_FIELD_COUNT)
                throw new IllegalArgumentException("Invalid line format: " + current);


        });

        reader.close();
    }
}
