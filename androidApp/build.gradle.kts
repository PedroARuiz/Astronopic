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
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
        kotlinCompilerVersion = "1.4.20"
    }
}

dependencies {
    autoModules.apply {
        implementation(project(di))
        implementation(project(core))
        implementation(project(presentation.common))
        implementation(project(presentation.apod))
    }
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.compose.ui:ui:${Version.compose}")
    implementation("androidx.compose.material:material:${Version.compose}")
    implementation("androidx.compose.ui:ui-tooling:${Version.compose}")
    implementation("org.koin:koin-androidx-viewmodel:${Version.koin}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("io.coil-kt:coil:1.1.0")
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.4.0")
}