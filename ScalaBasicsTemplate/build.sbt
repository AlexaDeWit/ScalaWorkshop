organization := "se.evolvetechnology"
name := "Functional Programming in Scala Workshop"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.3"
scalacOptions ++= Seq(
  "-feature",
  "-language:higherKinds",
  "-deprecation",
  "-Ypartial-unification"
)
assemblyJarName in assembly := "ScalaWorkshop.jar"

libraryDependencies ++= Seq(
  "org.scalatest"      %% "scalatest"           % "3.0.4"         % "test"

)