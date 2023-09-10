plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.widgets"
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
    
    // coil dependencies
    implementation ("io.coil-kt:coil-compose:${rootProject.ext.get("coil_version")}")
    implementation ("io.coil-kt:coil-gif:${rootProject.ext.get("coil_gif_version")}")
}