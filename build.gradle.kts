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
        val jvmTest by getting

        val nativeMain by getting {
            dependencies {
                implementation(Deps.KtorClient.curl)
                implementation(Deps.Coroutines.coreNative)
            }
        }
        val nativeTest by getting
    }
}

apply(from = "./gradle/dokka.gradle.kts")
apply(from = "./gradle/publish.gradle.kts")
