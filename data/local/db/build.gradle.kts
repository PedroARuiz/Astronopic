plugins {
    MultiplatformMobileModule
    id("com.squareup.sqldelight")
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "service"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
                Dependency.apply {
                    implementation(sqDelight)
                    implementation(sqDelightCoroutines)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                DependencyAndroid.apply {
                    implementation(sqDelightDriver)
                }
            }
        }

        val iosMain by getting {
            dependencies {
                DependencyIOS.apply {
                    implementation(sqDelightDriver)
                }
            }
        }
    }
}

sqldelight {
    database("AstronopicDataBase") {
        packageName = "org.edrodev.astronopic.data.local.db"
        sourceFolders = listOf("sqldelight")
    }
}