# telegram-bot.kt

![Build](https://github.com/dragneelfps/telegram-bot.kt/workflows/Build/badge.svg) ![Release](https://github.com/dragneelfps/telegram-bot.kt/workflows/Release/badge.svg)

Multiplatform Telegram Bot Library written in Kotlin

## Using in your projects

The libraries are published to [Maven Central](https://search.maven.org/search?q=io.github.dragneelfps).

### Maven

Add dependencies (you can also add other modules that you need):

```xml
<dependency>
    <groupId>io.github.dragneelfps</groupId>
    <artifactId>telegram-bot.kt</artifactId>
    <version>[latest_version]</version>
</dependency>
```

### Gradle

Add dependencies (you can also add other modules that you need):

```groovy
dependencies {
    implementation 'io.github.dragneelfps:telegram-bot.kt:[latest_version]'
}
```

Make sure that you have either `jcenter()` or `mavenCentral()` in the list of repositories:

```
repository {
    jcenter()
}
```

### Gradle Kotlin DSL

Add dependencies (you can also add other modules that you need):

```groovy
dependencies {
    implementation("io.github.dragneelfps:telegram-bot.kt:[latest_version]")
}
```

## Using examples

- echo `./gradlew :examples:echo:run`
- echo-native `./gradlew :examples:echo-native:runDebugExecutableNative`
