plugins {
    kotlin("multiplatform")
    id("at.asitplus.gradle.conventions")
}

group = "mwe.example.child"

kotlin {
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                //put your multiplatform dependencies here
            }
        }

    }
}

publishing { repositories { mavenLocal() } }