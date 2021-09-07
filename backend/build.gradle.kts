import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springVersion = "2.5.4"

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.30"
	kotlin("plugin.spring") version "1.5.30"
	kotlin("plugin.jpa") version "1.5.30"
}

group = "me.davidffa"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springVersion")
	implementation("org.springframework.boot:spring-boot-starter-security:$springVersion")
	implementation("org.springframework.boot:spring-boot-starter-web:$springVersion")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("com.h2database:h2:1.4.200")
	runtimeOnly("org.postgresql:postgresql:42.2.23.jre7")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springVersion")
	testImplementation("org.springframework.security:spring-security-test:5.5.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "16"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
