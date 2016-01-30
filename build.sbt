
name := "scalando"

scalaVersion := "2.11.7"

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.7" % "test"
)
