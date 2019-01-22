import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlinVer: String by extra
    kotlinVer = "1.3.11"
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVer))
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVer")
    }
} // added

val kotlinVer: String by extra // added

plugins {
    kotlin("jvm") version "1.3.11"
}
apply(plugin = "kotlinx-serialization") // added

group = "org.yostane"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx") // added
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVer") // added
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.9.1") // added
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0") // added
    compile(kotlin("script-runtime"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses",
        "-Xuse-experimental=kotlin.Experimental", // added
        "-Xjvm-default=compatibility")
}