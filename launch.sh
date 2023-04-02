#!/bin/bash

# Compile the application.
find ./src -name "*.java" > sources.txt
mkdir -p out
javac -d out @sources.txt

# Launch the application with the scenario file as argument.
java -cp out me.hjordan.avaj.AvajLauncher scenario.txt
