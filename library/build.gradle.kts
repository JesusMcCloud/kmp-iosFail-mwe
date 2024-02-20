plugins {
    kotlin("multiplatform")
    id("at.asitplus.gradle.conventions")
}

group="mwe.example.parent"

kotlin {
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
         commonMain  {
            dependencies {
                api("mwe.example.child:library2")
            }
        }
    }
}

publishing { repositories { mavenLocal() } }