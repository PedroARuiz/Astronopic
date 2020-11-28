plugins {
    MultiplatformModule
}
kotlin {
    ios {
        binaries {
            framework {
                baseName = "core"
            }
        }
    }
}
