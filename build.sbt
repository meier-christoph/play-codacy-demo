name := "play-codacy-demo"

scalaVersion := "2.11.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  // "org.reactivemongo" %% "play2-reactivemongo" % "0.11.12"
)

// play
routesGenerator := InjectedRoutesGenerator
