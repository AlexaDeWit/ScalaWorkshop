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

val Http4sVersion = "0.18.0-M5"
val LogbackVersion = "1.2.3"
val circeVersion = "0.9.0-M1"

addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full
)

libraryDependencies ++= Seq(
  "org.http4s"         %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"         %% "http4s-circe"        % Http4sVersion,
  "org.http4s"         %% "http4s-dsl"          % Http4sVersion,
  "org.http4s"         %% "http4s-blaze-client" % Http4sVersion,
  "ch.qos.logback"     %  "logback-classic"     % LogbackVersion,
  "io.circe"           %% "circe-parser"        % circeVersion,
  "io.circe"           %% "circe-generic"       % circeVersion,
  "com.typesafe"       %  "config"              % "1.3.1",
  "org.scalatest"      %% "scalatest"           % "3.0.4"         % "test"

)