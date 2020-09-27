import Deps.Versions.coroutinesVersion
import Deps.Versions.ktorVersion
import Deps.Versions.serializationVersion

object Deps {

    object Versions {
        const val kotlinVersion = "1.4.10"
        const val ktorVersion = "1.4.0"
        const val serializationVersion = "1.0.0-RC"
        const val dokkaVersion = "1.4.10"
        const val coroutinesVersion = "1.3.9"
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
    const val kDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.1.0"


}
