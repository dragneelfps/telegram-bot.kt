plugins {
    kotlin("multiplatform") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
    id("org.jetbrains.dokka") version "1.4.10"
    `maven-publish`
    signing
}

val ktor_version = "1.4.0"
val serialization_version = "1.0.0-RC"

group = "io.github.dragneelfps"
val baseVersion = "0.0.1"
val buildNumber = System.getenv("GITHUB_RUN_NUMBER")
val snapshotVersion = when (buildNumber) {
    null -> "$baseVersion-private"
    else -> "$baseVersion.$buildNumber-SNAPSHOT"
}
version = System.getenv("RELEASE_VERSION") ?: snapshotVersion

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "13"
        }
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-logging:$ktor_version")
                implementation("io.ktor:ktor-client-serialization:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serialization_version")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.1.0")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-apache:$ktor_version")
                implementation("io.ktor:ktor-client-logging-jvm:$ktor_version")
                implementation("io.ktor:ktor-client-serialization-jvm:$ktor_version")
                implementation("ch.qos.logback:logback-classic:1.2.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
            }
        }
        val jvmTest by getting

        val nativeMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-curl:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9-native-mt")
            }
        }
        val nativeTest by getting
    }
}

publishing {
    repositories {
        maven {
            url = if (version.toString().endsWith("SNAPSHOT"))
                uri("https://oss.sonatype.org/content/repositories/snapshots")
            else
                uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")
            credentials {
                username = findProperty("ossrhUsername") as String? ?: System.getenv("OSSRH_USERNAME")
                password = findProperty("ossrhPassword") as String? ?: System.getenv("OSSRH_PASSWORD")
            }
        }
    }

    publications {
        create<MavenPublication>("default") {
            pom {
                name.set("TelegramBot.kt")
                description.set("Multiplatform Telegram Bot Library written in Kotlin")
                url.set("https://github.com/dragneelfps/telegram-bot.kt")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("dragneelfps")
                        name.set("Sourabh S Rawat")
                        email.set("dragneelfps@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/dragneelfps/telegram-bot.kt.git")
                    developerConnection.set("scm:git:ssh://github.com/dragneelfps/telegram-bot.kt.git")
                    url.set("https://github.com/dragneelfps/telegram-bot.kt")
                }
            }
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["default"])
}
