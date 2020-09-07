
name := "scalando"

scalaVersion := "2.13.3"

scalacOptions ++= Seq(
  "-deprecation",
  "-language:postfixOps"
)

scalacOptions in Test ++= Seq(
  "-Yrangepos"
)

val specs2Version = "4.10.3"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  "com.typesafe" % "config" % "1.4.0",
  "joda-time" % "joda-time" % "2.10.6",
  "org.specs2" %% "specs2-core" % specs2Version % "test",
  "org.specs2" %% "specs2-mock" % specs2Version % "test"
)
