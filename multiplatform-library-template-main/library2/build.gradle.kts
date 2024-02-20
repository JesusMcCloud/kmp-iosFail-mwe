import at.asitplus.gradle.*
import DatatypeVersions.encoding
plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("at.asitplus.gradle.conventions")
}

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
                api(serialization("cbor"))
                api(datetime())
                implementation("io.matthewnelson.kotlin-components:encoding-base16:${encoding}")
                api("io.matthewnelson.kotlin-components:encoding-base64:${encoding}")
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

val javadocJar = setupDokka(baseUrl = "https://github.com/JesusMcCloud/kmp-iosFail-mwe/tree/main/multiplatform-library-template-main", multiModuleDoc = true)


publishing {
    publications {
        withType<MavenPublication> {
            artifact(javadocJar)
        }
    }
    repositories {
        mavenLocal {

        }
    }
}