plugins {
    id(Plugins.androidLibraryPlugin)
    id(Plugins.kotlinAndroidPlugin)
}

android {
    namespace = "com.example.gifitemdetail"
    compileSdk = AndroidVersioning.compileSdk

    defaultConfig {
        minSdk = AndroidVersioning.minSdk

        testInstrumentationRunner = AndroidVersioning.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
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
    implementation (project(":common"))

    implementation (Libraries.AndroidX.core)
    implementation (Libraries.AndroidX.appCompat)
    implementation (Libraries.AndroidX.material)
    implementation (Libraries.AndroidX.constraintlayout)
    androidTestImplementation (Libraries.Test.junitExt)
    androidTestImplementation (Libraries.Test.espresso)

    // compose dependencies
    implementation (Libraries.Compose.composeUi)
    implementation (Libraries.Compose.composeMaterial)
    implementation (Libraries.Compose.composePreview)
    debugImplementation (Libraries.Compose.composeUiTooling)
    implementation (Libraries.Compose.composeActivity)

    // Test
    testImplementation(Libraries.Test.robolectric)
    testImplementation(Libraries.Test.mockk)
    testImplementation (Libraries.Compose.composeTest)
    testImplementation (Libraries.Test.junit)
    debugImplementation(Libraries.Test.testManifest)
}