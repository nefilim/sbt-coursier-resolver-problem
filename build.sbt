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

lazy val mapCore = Seq("com.navteq" % "mapcore" % "19.01.07.00"
  exclude("com.navteq.umr", "UMREJB")
)
lazy val tileCommons = Seq("com.here.map.core" %% "tile-commons" % "2.61"
  //exclude("com.navteq.unicode.normalizer", "UnicodeNormalizer") // MUST exclude this for coursier to work
  //exclude("com.navteq.umr", "UMREJB") // OR exclude this for coursier to work
  exclude("com.here.prime", "datastore-client") // no DS1!
  exclude("xerces", "xerces")
)

libraryDependencies ++= tileCommons ++ mapCore

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "sbt-coursier-exclude-problem"
  )

