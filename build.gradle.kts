import org.jetbrains.kotlin.utils.addToStdlib.cast

plugins {
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
    kotlin("plugin.jpa") version Versions.kotlin
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

sourceSets {
    main {
        output.setResourcesDir(kotlin.classesDirectory)
    }
}


dependencies {
    implementation("com.mysql:mysql-connector-j:${Versions.mysql}")
    implementation("org.hibernate:hibernate-entitymanager:${Versions.hibernate}")
    testImplementation("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}
