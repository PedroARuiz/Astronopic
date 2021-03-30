plugins {
    MultiplatformMobileModule
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
        commonMain {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.data.local.db))
                Dependency.apply {
                    //implementation(sqDelightCoroutines)
                }
            }
        }
    }
}