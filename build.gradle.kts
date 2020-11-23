buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
        classpath("com.android.tools.build:gradle:4.2.0-alpha16")
    }
}
group = "org.edrodev.astronopic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
