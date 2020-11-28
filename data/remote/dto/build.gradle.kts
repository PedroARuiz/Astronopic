plugins {
    MultiplatformModule
    kotlin("plugin.serialization") version "1.4.0"
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "dto"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                Dependency.apply {
                    implementation(serialization)
                }
            }
        }
    }
}
