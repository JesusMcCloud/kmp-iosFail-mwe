plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("module.publication")
}
group="mwe.example.parent"
kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
         commonMain  {
            dependencies {
                api("mwe.example.child:library2")
            }
        }
         commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}
