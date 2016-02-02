#!/usr/bin/env bash

cd `pwd`/../../../../
echo `pwd`

mkdir -p target/manual

javac src/main/java/com/jcranky/scalando/cap01/Foto.java -d target/manual
javap -p target/manual/com/jcranky/scalando/cap01/Foto
