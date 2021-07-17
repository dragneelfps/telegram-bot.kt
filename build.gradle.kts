plugins {
    kotlin("multiplatform") version Deps.Versions.kotlinVersion
    kotlin("plugin.serialization") version Deps.Versions.kotlinVersion
    id("org.jetbrains.dokka") version Deps.Versions.dokkaVersion
    id("io.gitlab.arturbosch.detekt") version Deps.Versions.detektVersion
    id("com.github.ben-manes.versions") version "0.39.0"
}

group = "io.github.dragneelfps"
version = Ci.version

repositories {
    mavenCentral()
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    macosX64()
    linuxX64()
    mingwX64()

    @Suppress("UNUSED_VARIABLE")
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

detekt {
    input = files("src/commonMain/kotlin")
    reports {
        html.enabled = true
        xml.enabled = true
    }
}

apply(plugin = "dokka-config")
apply(plugin = "publish-config")