plugins {
    MultiplatformMobileModule
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
        commonMain {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.domain.model))
            }
        }
    }
}
