#!/usr/bin/env bash

cd `pwd`/../../../../

mkdir -p target/manual

scalac src/main/scala/com/jcranky/scalando/cap01/Foto.scala -d target/manual
javap -p target/manual/com/jcranky/scalando/cap01/Foto
