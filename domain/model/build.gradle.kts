plugins {
    MultiplatformMobileModule
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "model"
            }
        }
    }
}
