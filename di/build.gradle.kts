plugins {
    id (Plugins.kotlinPlugin)
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    //koin dependencies
    implementation(Libraries.Koin.koinCore)
}