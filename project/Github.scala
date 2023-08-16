object Github {
  val orgToken: String = sys.env.getOrElse("ORG_TOKEN", "")
  val gitHubUser: String = sys.env.getOrElse("GITHUB_USER", "_")
  val gitHubToken: String = sys.env.getOrElse("GITHUB_TOKEN", "")
  val orgTokenOrElseGithubToken: String = if (orgToken.isEmpty) gitHubToken else orgToken

  val packageRepoBase = "maven.pkg.github.com"
  val githubOwner: String = "nikpalyi"
  val gitHubRepo = "practice-akka"
  val realm = "GitHub Package Registry"
  val packageRepo = s"https://$packageRepoBase/$githubOwner/$gitHubRepo"
}
