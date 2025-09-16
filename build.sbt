import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "todo.native.cli"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.7.3"
libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "mainargs" % "0.7.6",
  "com.lihaoyi" %%% "fansi" % "0.5.1",
  "com.lihaoyi" %%% "os-lib" % "0.11.5",
  "com.lihaoyi" %%% "upickle" % "4.3.2",
  "org.ekrich" %%% "sjavatime" % "1.4.0",
  "com.outr" %%% "scribe" % "3.17.0",
  "com.outr" %%% "scribe-file" % "3.17.0",
  "org.scalatest" %%% "scalatest" % "3.2.19" % Test
)
scalacOptions ++= Seq(
  "-Wunused:all"
)
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}
