plugins {
    MultiplatformMobileModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "presentationCore"
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(autoModules.core))
            }
        }

        val androidMain by getting {
            dependencies {
                DependencyAndroid.apply {
                    implementation(lifecycleViewModel)
                }
            }
        }
    }
}
