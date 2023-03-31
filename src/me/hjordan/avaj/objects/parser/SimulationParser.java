package me.hjordan.avaj.objects.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimulationParser {

    private String simulationPath;

    public SimulationParser(String simulationPath) {
        this.simulationPath = simulationPath;
    }

    public void parse() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.simulationPath));
        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
