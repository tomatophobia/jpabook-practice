plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "jpa-practice"
include("src:main:untitled")
findProject(":src:main:untitled")?.name = "untitled"
