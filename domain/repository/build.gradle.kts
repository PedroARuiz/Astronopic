plugins {
    MultiplatformModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "domainRepository"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.domain.model))
            }
        }
    }
}
