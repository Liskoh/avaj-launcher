## Avaj-Launcher [![CodeFactor](https://www.codefactor.io/repository/github/liskoh/avaj-launcher/badge)](https://www.codefactor.io/repository/github/liskoh/avaj-launcher)

The Avaj-Launcher project is an air traffic control simulator written in Java. The program takes as input a scenario file containing information about planes, weather, and flight conditions, and simulates the behavior of these planes in the given environment.
Installation

To run the Avaj-Launcher simulator, you will need to have Java 8 or later installed on your system. If you do not have Java installed, you can download it from the official Java website: https://www.java.com/en/download/

Once Java is installed, you can clone this repository to your local machine using Git:

# bash

    git clone https://github.com/Liskoh/avaj-launcher.git

# Usage

To run the Avaj-Launcher simulator, navigate to the root directory of the project and compile the Java source code:

    javac src/*.java -d out/

Then, run the program with the following command:

    java -classpath out/ avaj.Simulator scenario.txt

Replace scenario.txt with the name of the scenario file you want to use.

The simulator will output information about the planes and their behavior to the console, as well as a file named simulation.txt that contains a log of the simulation.
Scenario File Format

The scenario file should be a plain text file with the following format:

    The first line contains an integer n, the number of times the simulation should run.
    Each subsequent line contains information about a single aircraft, in the following format:

    TYPE NAME LONGITUDE LATITUDE HEIGHT

Where TYPE is the type of the aircraft (Baloon, Helicopter, or JetPlane), NAME is a unique identifier for the aircraft, and LONGITUDE, LATITUDE, and HEIGHT are its starting coordinates.

The simulator also supports changing weather conditions during the simulation. To specify weather changes, add the following line to the scenario file:

    WEATHER longitude latitude height

Where longitude, latitude, and height are the coordinates of the weather change.