import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.11"
    val nebulaKotlinVersion = "1.3.11"
    val nebulaProjectVersion = "5.2.1"
    val springBootVersion = "2.1.1.RELEASE"
    val springDependencyManagementVersion = "1.0.6.RELEASE"

    idea
    java
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("io.spring.dependency-management") version springDependencyManagementVersion
    id("nebula.kotlin") version nebulaKotlinVersion
    id("nebula.project") version nebulaProjectVersion
    id("org.springframework.boot") version springBootVersion
}

val jacksonVersion = "2.9.7"
val kotlinLoggingVersion = "1.6.20"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
}

idea {
    module.isDownloadJavadoc = true
    project {
        vcs = "Git"
        languageLevel = IdeaLanguageLevel(java.sourceCompatibility)
    }
}

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(arrayOf("-Xlint:all", "-parameters"))
        options.setIncremental(true)
    }
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            javaParameters = true
            jvmTarget = java.targetCompatibility.name
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = java.targetCompatibility.name
        }
    }
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
