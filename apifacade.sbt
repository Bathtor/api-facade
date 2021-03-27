enablePlugins(ScalaJSPlugin)
enablePlugins(JSDependenciesPlugin)

name := "Roll20 API Facade"

organization := "com.lkroll"

scalaVersion := "2.13.5"
crossScalaVersions := Seq("2.11.12", "2.12.13", "2.13.5")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/Bathtor/api-facade"))
scmInfo := Some(
                ScmInfo(url("https://github.com/Bathtor/api-facade"),
                            "git@github.com:Bathtor/api-facade.git"))
developers := List(Developer(id = "lkroll",
                             name = "Lars Kroll",
                             email = "bathtor@googlemail.com",
                             url = url("https://github.com/Bathtor")))
publishMavenStyle := true

// Add sonatype repository settings
sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
publishTo := sonatypePublishToBundle.value

import ReleaseTransformations._

releaseCrossBuild := true // true if you cross-build the project for multiple Scala versions
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("+publishSigned"),
  releaseStepCommand("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)

jsDependencies += ProvidedJS / "Roll20Extras.js"

