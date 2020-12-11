plugins {
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    implementation("com.android.tools.build:gradle:7.0.0-alpha02")
}