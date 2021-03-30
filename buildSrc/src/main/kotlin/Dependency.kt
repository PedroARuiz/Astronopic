object Dependency {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Version.dateTime}"
    const val koinCore = "io.insert-koin:koin-core:${Version.koin}"
    const val ktorClient = "io.ktor:ktor-client-core:${Version.ktor}"
    const val ktorClientJson = "io.ktor:ktor-client-json:${Version.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Version.ktor}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"
    const val sqDelight = "com.squareup.sqldelight:runtime:${Version.sqDelight}"
    const val sqDelightCoroutines = "com.squareup.sqldelight:coroutines-extensions:${Version.sqDelight}"
}

object DependencyTest {
    const val kotestAssertions = "io.kotest:kotest-assertions-core:${Version.kotest}"
    const val mockk = "io.mockk:mockk-common:${Version.mockk}"
}

object DependencyJVM {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val ktorClient = "io.ktor:ktor-client-okhttp:${Version.ktor}"
    const val sqDelightDriver = "com.squareup.sqldelight:sqlite-driver:${Version.sqDelight}"
}

object DependencyTestJVM {
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
}

object DependencyAndroid {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val koin = "io.insert-koin:koin-android:${Version.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:3.0.1-beta-1"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val sqDelightDriver = "com.squareup.sqldelight:android-driver:${Version.sqDelight}"
}

object DependencyIOS {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Version.coroutines}"
    const val ktorClient = "io.ktor:ktor-client-ios:${Version.ktor}"
    const val sqDelightDriver = "com.squareup.sqldelight:native-driver:${Version.sqDelight}"
}
