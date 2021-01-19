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
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}")
    implementation("com.android.tools.build:gradle:7.0.0-alpha04")
    //implementation("com.squareup.sqldelight:gradle-plugin:${Version.sqDelight}")
}