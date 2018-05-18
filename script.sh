#! /bin/bash
javac -d out/ -Xlint src/*.java
cd out/
java BreadthFirstSearch tasks.txt elements.txt
java Astar tasks.txt elements.txt
