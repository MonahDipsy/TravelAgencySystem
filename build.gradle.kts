import org.jetbrains.compose.desktop.application.dsl.TargetFormat
val kspVersion: String by project
val roomVersion: String by project
val navigationVersion:String by project

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp")

    id("androidx.room")
}

group = "com.github.com.stephenwanjala"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.compose.material3:material3-desktop:1.6.11")
    implementation("org.jetbrains.compose.material:material-icons-extended:1.6.10")
    implementation("androidx.room:room-runtime:$roomVersion")
//    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("org.jetbrains.androidx.navigation:navigation-compose:$navigationVersion")

}

room {
    schemaDirectory(File("$projectDir/schemas").absolutePath)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "TravelAgency"
            packageVersion = "1.0.0"
        }
    }
}

