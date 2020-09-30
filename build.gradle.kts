plugins {
    kotlin("multiplatform") version Deps.Versions.kotlinVersion
    kotlin("plugin.serialization") version Deps.Versions.kotlinVersion
    id("org.jetbrains.dokka") version Deps.Versions.dokkaVersion
    `maven-publish`
    signing
}

group = "io.github.dragneelfps"
version = Ci.version

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        browser()
        nodejs()
    }
    macosX64()
    linuxX64()
    mingwX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.KtorClient.core)
                implementation(Deps.KtorClient.logging)
                implementation(Deps.KtorClient.serialization)
                implementation(Deps.kSerialization)
                implementation(Deps.kDateTime)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(Deps.KtorClient.apache)
                implementation(Deps.KtorClient.loggingJvm)
                implementation(Deps.KtorClient.serializationJvm)
                implementation(Deps.logback)
                implementation(Deps.Coroutines.core)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(Deps.Coroutines.core)
            }
        }

        // Native START
        val nativeMain by creating {
            dependencies {
                implementation(Deps.KtorClient.curl)
                implementation(Deps.Coroutines.coreNative)
            }
        }
        val macosX64Main by getting {
            dependencies {
                dependsOn(nativeMain)
            }
        }
        val linuxX64Main by getting {
            dependencies {
                dependsOn(nativeMain)
            }
        }
        val mingwX64Main by getting {
            dependencies {
                dependsOn(nativeMain)
            }
        }
        // Native END
    }
}

apply(from = "./gradle/dokka.gradle.kts")
apply(from = "./gradle/publish.gradle.kts")
