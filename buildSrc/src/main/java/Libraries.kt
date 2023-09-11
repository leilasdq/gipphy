object Libraries {

    object AndroidX {
        private const val coreVersion = "1.7.0"
        private const val appCompatVersion = "1.6.1"
        private const val materialVersion = "1.9.0"
        private const val constraintlayoutVersion = "2.1.4"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"
    }

    object Test {
        private const val junitVersion = "4.13.2"
        private const val junitExtVersion = "1.1.5"
        private const val espressoVersion = "3.5.1"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

    object Compose {
        private const val composeVersion = "1.4.0-rc01"
        private const val activityComposeVersion = "1.7.2"

        const val composeUi = "androidx.compose.ui:ui:$composeVersion"
        const val composeMaterial = "androidx.compose.material:material:$composeVersion"
        const val composePreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val composeTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val composeActivity = "androidx.activity:activity-compose:$activityComposeVersion"
    }

    object Coil {
        private const val coilVersion = "2.2.2"
        private const val coilGifVersion = "2.1.0"

        const val coil = "io.coil-kt:coil-compose:$coilVersion"
        const val coilGif = "io.coil-kt:coil-gif:$coilGifVersion"
    }

    object Koin {
        private const val koinVersion = "3.4.3"
        private const val koinExtVersion = "3.3.2"

        const val koinNavigation = "io.insert-koin:koin-androidx-navigation:$koinExtVersion"
        const val koinTest = "io.insert-koin:koin-test-junit4:$koinExtVersion"
        const val koinCore = "io.insert-koin:koin-core:$koinVersion"
        const val koinCompose = "io.insert-koin:koin-androidx-compose:$koinVersion"
        const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
    }
    object Paging {
        private const val pagingVersion = "3.2.0"

        const val pagingRunTime = "androidx.paging:paging-runtime-ktx:$pagingVersion"
        const val pagingCommonTest = "androidx.paging:paging-common-ktx:$pagingVersion"
        const val pagingCompose = "androidx.paging:paging-compose:$pagingVersion"
        const val pagingCommon = "androidx.paging:paging-common:$pagingVersion"
    }

    object Navigation {
        private const val navigationVersion = "2.5.0"

        const val navigationCompose = "androidx.navigation:navigation-compose:$navigationVersion"
    }
}