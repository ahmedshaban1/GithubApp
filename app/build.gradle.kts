plugins {
    id(GradlePluginId.ANDROID_APP)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
}

dependencies {
    commonDevelopmentDependencies()
    diDependencies()
    implementation(project(FeaturesDependency.search))
}

