object Dependency {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.dateTime}"
    const val koinCore = "org.koin:koin-core:${Version.koin}"
    const val ktorClient = "io.ktor:ktor-client-core:${Version.ktor}"
    const val ktorClientJson = "io.ktor:ktor-client-json:${Version.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Version.ktor}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"
}

object DependencyTest {
    const val kotestAssertions = "io.kotest:kotest-assertions-core:${Version.kotest}"
    const val mockk = "io.mockk:mockk-common:${Version.mockk}"
}

object DependencyJVM {
    const val ktorClient = "io.ktor:ktor-client-okhttp:${Version.ktor}"
}

object DependencyTestJVM {
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
}

object DependencyIOS {
    const val ktorClient = "io.ktor:ktor-client-ios:${Version.ktor}"
}
