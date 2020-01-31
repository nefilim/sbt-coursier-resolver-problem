import sbt._

object Dependencies {

  object NavteqNokia {
    lazy val mapCore = Seq("com.navteq" % "mapcore" % "19.01.07.00"
      exclude("com.navteq.umr", "UMREJB")
    )
    lazy val tileCommons = Seq("com.here.map.core" %% "tile-commons" % "2.61"
      exclude("com.navteq.unicode.normalizer", "UnicodeNormalizer") // MUST exclude this for coursier to work 
      exclude("com.here.prime", "datastore-client") // no DS1!
      exclude("xerces", "xerces")
    )
  }
}
