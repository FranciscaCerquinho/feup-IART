#! /bin/bash
javac -d out/ -Xlint src/*.java
cd out/
java Astar tasks.txt elements.txt $1
