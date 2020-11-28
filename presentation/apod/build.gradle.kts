plugins {
    MultiplatformModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "presentationApod"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(autoModules.core))
                api(project(autoModules.presentation.common))
                implementation(project(autoModules.domain.useCase))
                implementation(Dependency.coroutinesCore)
            }
        }
    }
}
