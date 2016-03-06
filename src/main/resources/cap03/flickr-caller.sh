#!/usr/bin/env bash

cd `pwd`/../../../../

mkdir -p target/manual

scalac src/main/scala/com/jcranky/scalando/cap03/FlickrCallerCMain.scala -d target/manual
javap -p target/manual/com/jcranky/scalando/cap03/FlickrCallerCVal
