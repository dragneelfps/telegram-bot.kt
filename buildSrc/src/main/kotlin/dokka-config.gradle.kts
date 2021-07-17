plugins {
    id("org.jetbrains.dokka")
}

val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

val dokkaJavadocJar by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    from(dokkaHtml.outputDirectory)
    archiveClassifier.set("javadoc")
}
