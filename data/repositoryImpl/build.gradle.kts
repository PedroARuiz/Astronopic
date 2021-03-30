plugins {
    MultiplatformMobileModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "repositoryImpl"
            }
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(autoModules.core))
                implementation(project(autoModules.domain.model))
                implementation(project(autoModules.domain.repository))
                implementation(project(autoModules.data.remote.dto))
                implementation(project(autoModules.data.remote.remoteDataSource))
                implementation(project(autoModules.data.local.db))
                implementation(project(autoModules.data.local.localDataSource))
            }
        }
    }
}
