plugins {
    MultiplatformMobileModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "useCase"
            }
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.domain.model))
                implementation(project(autoModules.domain.repository))
            }
        }

    }
}
