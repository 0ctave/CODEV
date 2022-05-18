plugins {
    id("java")
}

group = "fr.bloctave"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.github.sarxos:webcam-capture:0.3.10")
    implementation("org.apache.cassandra:cassandra-all:0.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}