plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}")
    implementation("com.android.tools.build:gradle:7.0.0-alpha12")
    //implementation("com.squareup.sqldelight:gradle-plugin:${Version.sqDelight}")
}