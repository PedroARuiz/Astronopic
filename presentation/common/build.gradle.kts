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
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
            }
        }
    }
}
