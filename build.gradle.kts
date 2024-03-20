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
        // persistence.xml 리소스 파일 빌드 위치 변경
        output.setResourcesDir(kotlin.classesDirectory)
        // 엔티티 이름 충돌 방지를 위해 빌드 타겟에서 제외
        kotlin.exclude("jpabook/start/pr1/**")
        kotlin.exclude("jpabook/start/pr2/**")
        kotlin.exclude("jpabook/start/pr3/**")
    }
}

tasks.compileJava {
    dependsOn("processResources")
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
