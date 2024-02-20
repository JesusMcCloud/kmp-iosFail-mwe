plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("module.publication")
}

group = "mwe.example.child"

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
         commonMain {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
         commonTest  {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}



android {
    namespace = "org.jetbrains.kotlinx.multiplatform.library.template2"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
