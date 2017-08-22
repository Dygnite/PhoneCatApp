name := """play-java-phones"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += guice
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
