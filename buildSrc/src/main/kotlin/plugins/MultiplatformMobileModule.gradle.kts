//import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    //maven(url = "https://kotlin.bintray.com/kotlinx/")
}

group = "org.edrodev.astronopic"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    ios()

    sourceSets {

        /*getByName("commonMain") {
            dependencies {
                Dependency.apply {
                    implementation(coroutinesCore)
                    implementation(dateTime)
                }
            }
        }
        getByName("commonTest") {
            dependencies {
                DependencyTest.apply {
                    implementation(kotestAssertions)
                    implementation(mockk)
                }
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        getByName("androidMain") {
            dependencies {
                DependencyJVM.apply {
                    implementation(coroutinesCore)
                }
            }
        }*/

        /*getByName("iosMain") {
            dependencies {
                DependencyIOS.apply {
                    api(coroutinesCore)
                }
            }
        }*/

        /*getByName("androidTest") {
            dependencies {
                DependencyTestJVM.apply {
                    implementation(coroutinesTest)
                    implementation(kotlin("test-junit"))
                    implementation(jUnit)
                    implementation(mockk)
                    //implementation("io.kotest:kotest-framework:${Version.kotest}") // for kotest framework
                    //implementation("io.kotest:kotest-property:${Version.kotest}") // for kotest property test
                }
            }
        }*/
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

/*val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)*/
