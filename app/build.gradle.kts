plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.gipphyapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.gipphyapplication"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
}

dependencies {

    implementation (project(":domain"))
    implementation (project(":data"))
    implementation (project(":common"))
    implementation (project(":widgets"))
    implementation (project(":feature:giflist"))
    implementation (project(":feature:gifitemdetail"))

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

    //koin dependencies
    implementation (Libraries.Koin.koinNavigation)
    testImplementation (Libraries.Koin.koinTest)
    implementation (Libraries.Koin.koinCore)
    implementation (Libraries.Koin.koinCompose)
    implementation (Libraries.Koin.koinAndroid)

    // navigation
    implementation (Libraries.Navigation.navigationCompose)
}