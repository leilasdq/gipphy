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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // compose dependencies
    implementation ("androidx.compose.ui:ui:${rootProject.ext.get("compose_version")}")
    implementation ("androidx.compose.material:material:${rootProject.ext.get("compose_version")}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${rootProject.ext.get("compose_version")}")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${rootProject.ext.get("compose_version")}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${rootProject.ext.get("compose_version")}")
    implementation ("androidx.activity:activity-compose:1.7.2")

    // coil dependencies
    implementation ("io.coil-kt:coil-compose:${rootProject.ext.get("coil_version")}")
    implementation ("io.coil-kt:coil-gif:${rootProject.ext.get("coil_gif_version")}")

    //koin dependencies
    implementation ("io.insert-koin:koin-androidx-navigation:${rootProject.ext.get("koin_extentions_version")}")
    testImplementation ("io.insert-koin:koin-test-junit4:${rootProject.ext.get("koin_extentions_version")}")
    implementation ("io.insert-koin:koin-core:${rootProject.ext.get("koin_version")}")
    implementation ("io.insert-koin:koin-androidx-compose:${rootProject.ext.get("koin_version")}")
    implementation ("io.insert-koin:koin-android:${rootProject.ext.get("koin_version")}")

    // paging
    implementation ("androidx.paging:paging-runtime-ktx:${rootProject.ext.get("paging_version")}")
    // alternatively - without Android dependencies for tests
    testImplementation ("androidx.paging:paging-common-ktx:${rootProject.ext.get("paging_version")}")
    implementation ("androidx.paging:paging-compose:${rootProject.ext.get("paging_version")}")
}