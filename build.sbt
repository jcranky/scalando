
name := "scalando"

scalaVersion := "2.11.8"

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "joda-time" % "joda-time" % "2.9.4",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5",
  "org.specs2" %% "specs2-core" % "3.8.4" % "test"
)
