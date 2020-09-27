object Ci {
    const val baseVersion = "0.0.1"
    val buildNumber = System.getenv("GITHUB_RUN_NUMBER")
    val snapshotVersion = when (buildNumber) {
        null -> "$baseVersion-private-SNAPSHOT"
        else -> "$baseVersion.$buildNumber-SNAPSHOT"
    }
    val version = System.getenv("RELEASE_VERSION") ?: snapshotVersion
}
