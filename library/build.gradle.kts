import at.asitplus.gradle.serialization
import at.asitplus.gradle.setupDokka

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
         commonMain  {
            dependencies {
                api("mwe.example.child:library2")
            }
        }
    }
}

val javadocJar = setupDokka(baseUrl = "https://github.com/JesusMcCloud/kmp-iosFail-mwe/tree/main", multiModuleDoc = true)


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