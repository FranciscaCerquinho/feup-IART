#! /bin/bash
javac -d out/ -Xlint src/*.java
cd out/
<<<<<<< HEAD
java BreadthFirstSearch tasks.txt elements.txt
java Astar tasks.txt elements.txt
=======
java Astar tasks.txt elements.txt $1
>>>>>>> 200f7f5243ee37594411b84842d789fce6927da9
