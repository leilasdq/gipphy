plugins {
    id (Plugins.kotlinPlugin)
}

dependencies {
    implementation(project(":common"))

    //koin dependencies
    implementation(Libraries.Koin.koinCore)
    //paging dependencies
    implementation(Libraries.Paging.pagingCommon)
}
