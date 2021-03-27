enablePlugins(ScalaJSPlugin)
enablePlugins(JSDependenciesPlugin)

name := "Roll20 API Facade"

organization := "com.lkroll.roll20"

version := "1.2.3"

scalaVersion := "2.13.5"
crossScalaVersions := Seq("2.11.12", "2.12.13", "2.13.5")

jsDependencies += ProvidedJS / "Roll20Extras.js"

resolvers += Resolver.bintrayRepo("lkrollcom", "maven")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayPackageLabels := Seq("roll20", "api", "facade")
bintrayOrganization := Some("lkrollcom")
bintrayRepository := "maven"
