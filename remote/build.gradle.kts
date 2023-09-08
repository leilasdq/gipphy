import java.io.*
import java.io.FileInputStream
import java.util.*

//fun getLocalProperty(key: String, file: String = "local.properties"): Any {
//    val properties = Properties()
//    val localProperties = File(file)
//    if (localProperties.isFile) {
//        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
//            properties.load(reader)
//        }
//    } else error("File from not found")
//
//    return properties.getProperty(key)
//}
//
//task("printKey") {
//    doLast {
//        val key = getLocalProperty("API_KEY")
//        println(key)
//    }
//}

plugins {
    //id ("kotlin")
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

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    //ktor dependencies
    implementation("io.ktor:ktor-client-core:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-android:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-serialization:${rootProject.ext.get("ktor_version")}")
    implementation("io.ktor:ktor-client-logging:${rootProject.ext.get("ktor_version")}")
    implementation("ch.qos.logback:logback-classic:${rootProject.ext.get("logging_version")}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${rootProject.ext.get("serialization_version")}")

    //koin dependencies
    implementation("io.insert-koin:koin-core:${rootProject.ext.get("koin_version")}")
    implementation ("io.insert-koin:koin-android:${rootProject.ext.get("koin_version")}")


    // paging
    implementation("androidx.paging:paging-common:${rootProject.ext.get("paging_version")}")
}


/*
* Properties prop = new Properties()
        prop.load(new FileInputStream(new File('local.properties')))
        buildConfigField "String", "API_KEY", "\"${prop.getProperty("API_KEY")}\""
* */