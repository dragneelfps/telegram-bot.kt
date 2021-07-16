import Deps.Versions.coroutinesVersion
import Deps.Versions.ktorVersion
import Deps.Versions.serializationVersion

object Deps {

    object Versions {
        const val kotlinVersion = "1.5.21"
        const val ktorVersion = "1.6.1"
        const val serializationVersion = "1.2.2"
        const val dokkaVersion = "1.5.0"
        const val coroutinesVersion = "1.5.1"
        const val detektVersion = "1.15.0-RC1"
    }

    object KtorClient {
        const val core = "io.ktor:ktor-client-core:$ktorVersion"
        const val apache = "io.ktor:ktor-client-apache:$ktorVersion"

        const val logging = "io.ktor:ktor-client-logging:$ktorVersion"
        const val loggingJvm = "io.ktor:ktor-client-logging-jvm:$ktorVersion"

        const val serialization = "io.ktor:ktor-client-serialization:$ktorVersion"
        const val serializationJvm = "io.ktor:ktor-client-serialization-jvm:$ktorVersion"

        const val curl = "io.ktor:ktor-client-curl:$ktorVersion"
    }


    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val coreNative = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion-native-mt"
    }


    const val logback = ("ch.qos.logback:logback-classic:1.2.3")

    const val kSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion"
    const val kDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.2.1"


}
