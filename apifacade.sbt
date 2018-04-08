enablePlugins(ScalaJSPlugin)

name := "Roll20 API Facade"

organization := "com.lkroll.roll20"

version := "1.2.0-SNAPSHOT"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.11.11", "2.12.4")

jsDependencies += ProvidedJS / "Roll20Extras.js"