plugins {
    id ("kotlin")
}

dependencies {
    implementation(project(":common"))
    implementation("io.insert-koin:koin-core:3.4.3")
    implementation("androidx.paging:paging-common:${rootProject.ext.get("paging_version")}")
}
