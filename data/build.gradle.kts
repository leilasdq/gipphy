plugins {
    id (Plugins.androidLibraryPlugin)
    id (Plugins.kotlinAndroidPlugin)
}

android {
    compileSdk = AndroidVersioning.compileSdk
    namespace = "com.example.data"

    defaultConfig {
        minSdk = AndroidVersioning.minSdk

        testInstrumentationRunner = AndroidVersioning.testInstrumentationRunner
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

dependencies {
    implementation (project(":remote"))
    implementation (project(":domain"))
    implementation (project(":common"))

    //koin dependencies
    implementation (Libraries.Koin.koinCore)

    // paging
    implementation(Libraries.Paging.pagingCommon)
}