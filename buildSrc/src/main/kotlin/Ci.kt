object Ci {
    private const val baseVersion = "1.3.0"
    private val snapshotVersion = when (val buildNumber = System.getenv("GITHUB_RUN_NUMBER")) {
        null -> "$baseVersion-private-SNAPSHOT"
        else -> "$baseVersion.$buildNumber-SNAPSHOT"
    }
    val version = System.getenv("RELEASE_VERSION") ?: snapshotVersion
}
