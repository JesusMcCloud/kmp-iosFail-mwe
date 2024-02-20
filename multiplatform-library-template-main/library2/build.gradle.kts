plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("module.publication")
}

group = "mwe.example.child"

kotlin {
    applyDefaultHierarchyTemplate()
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
         commonTest  {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}