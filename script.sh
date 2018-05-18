#! /bin/bash
javac -d out/ -Xlint src/*.java
cd out/
java Interface tasks.txt elements.txt
