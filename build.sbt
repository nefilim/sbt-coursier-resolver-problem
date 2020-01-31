import Dependencies.NavteqNokia._
import sbt.Keys.version

ThisBuild / scalaVersion     := "2.11.12"
ThisBuild / version          := "7.0.0-SNAPSHOT"
ThisBuild / organization     := "xxx"
ThisBuild / organizationName := "XXX"

lazy val commonSettings = Seq(
  resolvers += "Here NCR Nexus3" at "https://artifactory.in.here.com/artifactory/ncr_nexus3_public/"
)

useCoursier := true

dependencyOverrides += "org.javassist" % "javassist" % "3.18.2-GA" // ${guava.version} declared by org.reflections:reflections:0.9.9-RC2
dependencyOverrides += "com.google.guava" % "guava" % "15.0" // ${guava.version} declared by org.reflections:reflections:0.9.9-RC2

libraryDependencies ++= tileCommons ++ mapCore

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "sbt-coursier-exclude-problem"
  )

