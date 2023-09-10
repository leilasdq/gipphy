plugins {
    id ("kotlin")
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    //koin dependencies
    implementation(Libraries.Koin.koinCore)
}