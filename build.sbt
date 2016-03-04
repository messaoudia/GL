name := """play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

// aapt-java repo
resolvers += "aapt-java repo" at "https://dl.bintray.com/outofcoffee/maven"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11",
  javaJdbc,
  cache,
  javaWs,
  "org.xerial" % "sqlite-jdbc" % "3.7.15-M1",

  // play mailer
  "com.typesafe.play" %% "play-mailer" % "3.0.1",
  "mysql" % "mysql-connector-java" % "5.1.18"

)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
