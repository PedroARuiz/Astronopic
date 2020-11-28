plugins {
    MultiplatformModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "remoteRepository"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.domain.model))
                implementation(project(autoModules.domain.repository))
                implementation(project(autoModules.data.remote.dto))
                implementation(project(autoModules.data.remote.dataSource))
            }
        }
    }
}
