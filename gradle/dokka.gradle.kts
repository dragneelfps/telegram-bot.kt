apply(plugin = "org.jetbrains.dokka")

val dokkaJavadoc by tasks.existing
val dokkaHtml by tasks.existing

val dokkaJavadocJar by tasks.registering(Jar::class) {
    dependsOn(dokkaJavadoc)
    from(dokkaJavadoc)
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    from(dokkaJavadoc)
    archiveClassifier.set("html")
}
