#!/bin/sh

find . -name "*.java" > sources.txt
javac -rc src sources.txt
java ua.unit.avaj.Simulator scenario.txt