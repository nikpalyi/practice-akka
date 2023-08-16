import Changelog.updateChangelog
import sbt._
import Github.{gitHubToken, packageRepoBase, realm}
import sbt.Keys.{credentials, thisProjectRef}
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.Version
import sbtrelease.Version.Bump.Minor

object Release {
  import ReleaseTransformations._

  val releaseBump: Version.Bump = Minor

  val publishWithCredentials: ReleaseStep = ReleaseStep(action = st => {
    val extracted = Project.extract(st)
    st.log.info("Setting credentials for publishing package")
    val newState = extracted.appendWithSession(
      Seq(
        ThisBuild / credentials := Seq(Credentials(realm, packageRepoBase, "_", gitHubToken))
      ),
      st
    )
    val ref = extracted.get(thisProjectRef)
    val newExtracted = Project.extract(newState)
    newExtracted.runAggregated(ref / (Global / releasePublishArtifactsAction), newState)
  })


  val releaseSteps: Seq[ReleaseStep] = Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    updateChangelog,
    commitReleaseVersion,
    tagRelease,
    publishWithCredentials,
    setNextVersion,
    commitNextVersion,
    pushChanges
  )
}
