plugins {
    MultiplatformMobileModule
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
        commonMain {
            dependencies {
                Dependency.apply {
                    implementation(serialization)
                }
            }
        }
    }
}
