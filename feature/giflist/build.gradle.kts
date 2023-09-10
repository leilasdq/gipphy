plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.giflist"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
}

dependencies {

    implementation (project(":domain"))
    implementation (project(":widgets"))

    implementation (Libraries.AndroidX.core)
    implementation (Libraries.AndroidX.appCompat)
    implementation (Libraries.AndroidX.material)
    implementation (Libraries.AndroidX.constraintlayout)
    testImplementation (Libraries.Test.junit)
    androidTestImplementation (Libraries.Test.junitExt)
    androidTestImplementation (Libraries.Test.espresso)

    // compose dependencies
    implementation (Libraries.Compose.composeUi)
    implementation (Libraries.Compose.composeMaterial)
    implementation (Libraries.Compose.composePreview)
    androidTestImplementation (Libraries.Compose.composeTest)
    debugImplementation (Libraries.Compose.composeUiTooling)
    implementation (Libraries.Compose.composeActivity)

    // coil dependencies
    implementation (Libraries.Coil.coil)
    implementation (Libraries.Coil.coilGif)

    //koin dependencies
    implementation (Libraries.Koin.koinNavigation)
    testImplementation (Libraries.Koin.koinTest)
    implementation (Libraries.Koin.koinCore)
    implementation (Libraries.Koin.koinCompose)
    implementation (Libraries.Koin.koinAndroid)

    // paging
    implementation (Libraries.Paging.pagingRunTime)
    // alternatively - without Android dependencies for tests
    testImplementation (Libraries.Paging.pagingCommonTest)
    implementation (Libraries.Paging.pagingCompose)
}