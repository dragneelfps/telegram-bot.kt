object Ci {
    private const val baseVersion = "1.2.1"
    private val buildNumber = System.getenv("GITHUB_RUN_NUMBER")
    private val snapshotVersion = when (buildNumber) {
        null -> "$baseVersion-private-SNAPSHOT"
        else -> "$baseVersion.$buildNumber-SNAPSHOT"
    }
    val version = System.getenv("RELEASE_VERSION") ?: snapshotVersion
}
