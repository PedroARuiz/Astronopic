plugins {
    MultiplatformModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "domainModel"
            }
        }
    }
}
