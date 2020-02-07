import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.61"
    kotlin("kapt") version "1.3.61"
    application
}

group = "dev.kakueki61"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "dev.kakueki61.CommandLineAtm"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.dagger:dagger:2.26")
    kapt("com.google.dagger:dagger-compiler:2.26")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}
