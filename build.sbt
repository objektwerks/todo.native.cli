import scalanative.build.Mode

enablePlugins(ScalaNativePlugin)

name := "todo.native.cli"
organization := "objektwerks"
version := "0.1"
scalaVersion := "3.7.0-RC1"
libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "mainargs" % "0.7.6",
  "com.lihaoyi" %%% "os-lib" % "0.11.4",
  "com.lihaoyi" %%% "upickle" % "4.1.0",
  "org.ekrich" %%% "sjavatime" % "1.3.0",
  "org.scalatest" %%% "scalatest" % "3.2.19" % Test
)
scalacOptions ++= Seq(
  "-Wunused:all"
)
nativeConfig ~= {
  _.withMode(Mode.releaseFast)
}