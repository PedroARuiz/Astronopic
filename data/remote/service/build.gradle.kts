plugins {
    MultiplatformMobileModule
    kotlin("plugin.serialization") version "1.4.0"
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
                implementation(project(autoModules.data.remote.dto))
                Dependency.apply {
                    implementation(ktorClient)
                    implementation(ktorClientSerialization)
                    implementation(ktorClientJson)
                    implementation(serialization)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                DependencyJVM.apply {
                    implementation(ktorClient)
                }
            }
        }
    }
}