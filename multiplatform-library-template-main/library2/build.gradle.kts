import at.asitplus.gradle.*
import DatatypeVersions.encoding
plugins {
    kotlin("multiplatform")
    id("at.asitplus.gradle.conventions")
    kotlin("plugin.serialization")
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
                api(kmmresult())
                api(serialization("json"))
                api(datetime())
                implementation("io.matthewnelson.kotlin-components:encoding-base16:${encoding}")
                implementation("io.matthewnelson.kotlin-components:encoding-base64:${encoding}")
            }
        }

        commonTest {
            dependencies {
                implementation(kotest("property"))
                implementation(kotlin("reflect"))
            }
        }

        jvmMain {
            dependencies {
                api(bouncycastle("bcpkix"))
            }
        }

    }
}

publishing { repositories { mavenLocal() } }