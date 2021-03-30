plugins {
    id("com.github.ben-manes.versions") version "0.38.0"
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
    }
}

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}
