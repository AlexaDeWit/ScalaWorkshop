organization := "se.evolvetechnology"
name := "Functional Programming in Scala Workshop"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.3"

mainClass in (Compile, run) := Some("se.evolvetechnology.scala.workshop.basic.Main")

scalacOptions ++= Seq(
  "-feature",
  "-language:higherKinds",
  "-deprecation",
  "-Ypartial-unification"
)
assemblyJarName in assembly := "ScalaWorkshop.jar"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core"   % "1.0.0-RC1",
  "org.typelevel" %% "cats-effect" % "0.5"
)

libraryDependencies ++= Seq(
  "org.scalatest"      %% "scalatest"           % "3.0.4"         % "test"

)