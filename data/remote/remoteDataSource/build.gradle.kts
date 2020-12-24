plugins {
    MultiplatformMobileModule
    kotlin("plugin.serialization") version "1.4.0"
}

kotlin {
    jvm()
    ios {
        binaries {
            framework {
                baseName = "remoteDataSource"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.data.remote.dto))
                implementation(project(autoModules.data.remote.service))
                Dependency.apply {
                    implementation(serialization)
                }
            }
        }
    }
}
