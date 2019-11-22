ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "Giovanni Martina"

lazy val exercises = (project in file("."))
  .settings(
    name := "Exercises"
  )
