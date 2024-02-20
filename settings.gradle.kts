pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "multiplatform-library-template"
include(":library")
includeBuild("multiplatform-library-template-main"){
    dependencySubstitution {
        substitute(module("mwe.example.child:library2")).using(project(":library2"))
    }
}