import Release._
import Github._

ThisBuild / scalaVersion := "2.13.11"

ThisBuild / organization := "com.niki"

ThisBuild / scalacOptions ++= Compiler.scalacOptions

ThisBuild / versionScheme := Some("semver-spec")

releaseVersionBump := releaseBump
releaseProcess := releaseSteps

lazy val root = (project in file("."))
  .settings(
    name := "practice-akka",
    libraryDependencies += "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % "1.1.3",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.16" % "test",
    libraryDependencies += "org.scalatestplus" %% "mockito-1-10" % "3.1.0.0" % "test",
    publishTo := Some(s"$realm".at(s"$packageRepo"))
  )

ThisBuild / publishMavenStyle := true
ThisBuild / credentials += Credentials(realm, packageRepoBase, gitHubUser, orgTokenOrElseGithubToken)
ThisBuild / resolvers += s"$realm".at(s"$packageRepo")