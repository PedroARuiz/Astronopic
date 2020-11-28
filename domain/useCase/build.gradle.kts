plugins {
    MultiplatformModule
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
        val commonMain by getting {
            dependencies {
                api(project(autoModules.core))
                api(project(autoModules.domain.model))
                implementation(project(autoModules.domain.repository))
            }
        }

    }
}
