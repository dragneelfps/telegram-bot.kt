plugins {
    id("org.jetbrains.dokka")
}

val dokkaJavadoc by tasks.existing
val dokkaHtml by tasks.existing

val dokkaJavadocJar by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    from(dokkaHtml)
    archiveClassifier.set("javadoc")
}
