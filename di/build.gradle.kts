plugins {
    MultiplatformModule
}
repositories {
    maven(url = "https://dl.bintray.com/ekito/koin")
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "di"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependency.koinCore)
                autoModules.apply {
                    implementation(project(domain.repository))
                    implementation(project(domain.useCase))
                    implementation(project(data.repositoryImpl))
                    implementation(project(data.remote.service))
                    implementation(project(data.remote.dataSource))
                    implementation(project(presentation.apod))
                }
            }
        }
    }
}
