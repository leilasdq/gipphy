plugins {
    id ("kotlin")
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    //koin dependencies
    implementation("io.insert-koin:koin-core:${rootProject.ext.get("koin_version")}")
}