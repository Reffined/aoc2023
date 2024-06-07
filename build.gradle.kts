plugins {
    kotlin("jvm") version "2.0.0"

}

group = "Reffined"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "reffined.MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from(
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    )

}



tasks.register<JavaExec>("buildAndRunJar") {
    group = "MyConfig"
    dependsOn(tasks.named("jar").get().path)
    classpath(files(tasks.named("jar").get().outputs.files))
}

kotlin {
    jvmToolchain(21)

}