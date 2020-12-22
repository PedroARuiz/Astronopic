plugins {
    MultiplatformModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "localDataSource"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.data.local.db))
                Dependency.apply {
                    //implementation(sqDelightCoroutines)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                DependencyJVM.apply {
                }
            }
        }

        val iosMain by getting {
            dependencies {
                DependencyIOS.apply {
                }
            }
        }
    }
}