plugins {
    application
    kotlin("jvm") version "1.4.10"
}

application {
    mainClassName = "EchoKt"
}

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}

dependencies {
    implementation("io.github.dragneelfps:telegram-bot.kt-jvm:+")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
}
