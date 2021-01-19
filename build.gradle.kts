plugins {
    id("com.github.ben-manes.versions") version "0.36.0"
}
buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:${Version.sqDelight}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    }
}

repositories {
    mavenCentral()
}
