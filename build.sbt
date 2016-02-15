name := """pear"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11",
  javaJdbc,
  cache,
  javaWs,
  "org.xerial" % "sqlite-jdbc" % "3.7.15-M1"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

includeFilter in (Assets, LessKeys.less) := "style.less" | "mainTest.less"