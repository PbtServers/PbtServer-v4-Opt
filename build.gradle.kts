import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

repositories {
    // ...
    mavenCentral()
    maven(url = "https://jitpack.io")
}

plugins {
    application
    id("com.github.johnrengelman.shadow") version ("7.1.1")
}

application {
    mainClass.set("com.pbtservers.server.PbtServer")
    // This is included because Shadow is buggy. Wait for https://github.com/johnrengelman/shadow/issues/613 to befixed.
    @Suppress("DEPRECATION")
    mainClassName = "com.pbtservers.server.PbtServer"
}

dependencies {
    implementation("com.github.Articdive:JNoise:3.0.2")
    implementation("com.github.Minestom:Minestom:98a6e73e99")
}

tasks.withType<ShadowJar> {
    archiveFileName.set("PbtServer-v4-Opt.jar")
}