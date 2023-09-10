import java.io.*
import java.util.*

plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdk = 33
    namespace = "com.example.remote"

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val projectProperties = readProperties(file("../local.properties"))
        buildConfigField("String", "API_KEY", "\"${projectProperties.getProperty("API_KEY")}\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}


dependencies {

    implementation (Libraries.AndroidX.core)
    implementation (Libraries.AndroidX.appCompat)
    implementation (Libraries.AndroidX.material)
    implementation (Libraries.AndroidX.constraintlayout)
    testImplementation (Libraries.Test.junit)
    androidTestImplementation (Libraries.Test.junitExt)
    androidTestImplementation (Libraries.Test.espresso)

    //ktor dependencies
    implementation("io.ktor:ktor-client-core:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-android:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-serialization:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-logging:${rootProject.ext.get("ktor_version")}")
    implementation("ch.qos.logback:logback-classic:${rootProject.ext.get("logging_version")}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${rootProject.ext.get("serialization_version")}")

    //koin dependencies
    implementation(Libraries.Koin.koinCore)
    //paging dependencies
    implementation(Libraries.Paging.pagingCommon)
}