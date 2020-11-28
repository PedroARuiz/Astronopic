plugins {
    id("com.android.application")
    kotlin("android")
}
group = "org.edrodev.astronopic"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}
dependencies {
    autoModules.apply {
        implementation(project(core))
        implementation(project(domain.useCase))
        implementation(project(domain.repository))
        implementation(project(data.remote.dataSource))
        implementation(project(data.remote.service))
        implementation(project(data.repositoryImpl))
        implementation(project(presentation.apod))
    }
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation(Dependency.coroutinesCore)
    implementation(Dependency.dateTime)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "org.edrodev.astronopic"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}