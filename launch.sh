#!/bin/sh

# This script is used to launch the application from the command line.

# Compile the application.
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt

# Launch the application with the scenario file as argument.
java me.hjordan.avaj.Main scenario.txt