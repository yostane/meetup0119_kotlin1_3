import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlinVer: String by extra
    kotlinVer = "1.3.20"
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVer))
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVer")
    }
} // for serialization

val kotlinVer: String by extra // for serialization

plugins {
    kotlin("jvm") version "1.3.20"
}
apply(plugin = "kotlinx-serialization") // for serialization

group = "org.yostane"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx") // for serialization and coroutines
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVer") // for serialization
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.9.1") // for serialization
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0") // added
    compile(kotlin("script-runtime"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses",
        "-Xuse-experimental=kotlin.Experimental", // for serialization
        "-Xjvm-default=compatibility")
}