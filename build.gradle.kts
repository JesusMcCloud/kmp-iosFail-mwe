import org.jetbrains.dokka.gradle.DokkaMultiModuleTask

plugins {
    id("at.asitplus.gradle.conventions") version "1.9.22+20240219" //Version can be omitted for composite build
}

group="mwe.example.parent"

//access dokka plugin from conventions plugin's classpath in root project → no need to specify version
apply(plugin = "org.jetbrains.dokka")
tasks.getByName("dokkaHtmlMultiModule") {
    (this as DokkaMultiModuleTask)
    outputDirectory.set(File("$buildDir/dokka"))
    includes.from("README.md")
    moduleName.set("MWE Parent")
}

allprojects {
    apply(plugin = "org.jetbrains.dokka")
    group = rootProject.group
}
