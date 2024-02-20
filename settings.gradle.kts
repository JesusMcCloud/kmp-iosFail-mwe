pluginManagement {
    repositories {
        maven {
            url = uri("https://raw.githubusercontent.com/a-sit-plus/gradle-conventions-plugin/mvn/repo")
            name = "aspConventions"
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "multiplatform-library-template"
include(":library")
includeBuild("multiplatform-library-template-main"){
    dependencySubstitution {
        substitute(module("mwe.example.child:library2")).using(project(":library2"))
    }
}