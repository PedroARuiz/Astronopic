object Dependency {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.dateTime}"
    const val ktorClient = "io.ktor:ktor-client-core:${Version.ktor}"
    const val ktorClientJson = "io.ktor:ktor-client-json:${Version.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Version.ktor}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"
}

object DependencyJVM {
    const val ktorClient = "io.ktor:ktor-client-okhttp:${Version.ktor}"
}

object DependencyIOS {
    const val ktorClient = "io.ktor:ktor-client-ios:${Version.ktor}"
}
