#!/usr/bin/env bash

cd `pwd`/../../../../

mkdir -p target/manual

javac src/main/java/com/jcranky/scalando/cap01/java/Foto.java -d target/manual
javap -p target/manual/com/jcranky/scalando/cap01/java/Foto
