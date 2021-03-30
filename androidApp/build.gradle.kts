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
    maven(url = "https://dl.bintray.com/ekito/koin")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
}

dependencies {
    autoModules.apply {
        implementation(project(di))
        implementation(project(core))
        implementation(project(presentation.common))
        implementation(project(presentation.apod))
    }
    implementation("com.google.android.material:material:1.4.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.3.0-rc01")
    implementation("androidx.compose.ui:ui:${Version.compose}")
    implementation("androidx.compose.material:material:${Version.compose}")
    implementation("androidx.compose.ui:ui-tooling:${Version.compose}")
    implementation("androidx.activity:activity-compose:1.3.0-alpha05")
    implementation(DependencyAndroid.koinCompose)
    implementation(DependencyAndroid.koin)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("io.coil-kt:coil:1.1.1")
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.6.2")
    implementation(DependencyAndroid.coroutinesCore)
    implementation(Dependency.dateTime)
}