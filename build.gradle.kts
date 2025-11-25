plugins {
    id("java")
    id("jacoco") // 🔥 agregamos JaCoCo
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// ✔ Usar JUnit 5
tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // generar reporte luego de los tests
}

// ✔ Configuración JaCoCo
jacoco {
    toolVersion = "0.8.10"
}

// ✔ Reporte HTML y XML
tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

// ✔ Verificación de cobertura mínima (95%)
tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                 minimum = BigDecimal("0.98")
            }
        }
    }
}

// ✔ Hacer que "gradle check" falle si no cumple 95%
tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}



