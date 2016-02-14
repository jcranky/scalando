
name := "scalando"

scalaVersion := "2.11.7"

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.2",
  "org.specs2" %% "specs2-core" % "3.7.1" % "test"
)
