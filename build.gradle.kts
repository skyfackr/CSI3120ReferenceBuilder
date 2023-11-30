
plugins {
    id("java")
}

group = "wang.skycloud.uocsi3120"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}



tasks.jar {
    manifest {
        attributes["Main-Class"] = "wang.skycloud.uocsi3120.MainClass"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}