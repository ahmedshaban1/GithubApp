import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler



// Define common dependencies for testing, so they can be easily updated across feature modules

fun DependencyHandler.addTestDependencies() {
    testImplementation(TestLibraryDependency.JUNIT)
    testImplementation(TestLibraryDependency.KOIN)
    androidTestImplementation(TestLibraryDependency.JUNIT_ANDROID)
    androidTestImplementation(TestLibraryDependency.ESPRESSO)
    testImplementation(LibraryDependency.MOCKKTESTING)
    androidTestImplementation(LibraryDependency.MOCKkANDROIDTESTING)
    testImplementation(LibraryDependency.COROUTINESTESTING)
    testImplementation(LibraryDependency.LIFECYCLETESTING)
    androidTestImplementation(TestLibraryDependency.testandroidx_junit)
    androidTestImplementation(TestLibraryDependency.testandroidx_runner)
    androidTestImplementation(TestLibraryDependency.testandroidx_rules)
    androidTestImplementation(TestLibraryDependency.fragments_testing)
    androidTestImplementation(TestLibraryDependency.androidx_testing_core)
    androidTestImplementation(TestLibraryDependency.barista)
    androidTestImplementation(TestLibraryDependency.JUNIT)
    androidTestImplementation(TestLibraryDependency.arc_core)
    androidTestImplementation(TestLibraryDependency.KOIN)




}
// Define common dependencies, so they can be easily updated across feature modules
fun DependencyHandler.commonDevelopmentDependencies() {
    api(LibraryDependency.APPCOMPAT)
    api(LibraryDependency.CONSTRAINT)
    api(LibraryDependency.MATERIAL)
    api(LibraryDependency.PICASSO)
    api(LibraryDependency.ROUNDED_IMAGE_VIEW)
    api(LibraryDependency.RECYCLERVIEW)
    api(LibraryDependency.LIFECYCLEEXTENSIONS)
    api(LibraryDependency.COREKTX)
    api(LibraryDependency.LIFECYCLEViewModel)


}

fun DependencyHandler.compose() {

    implementation(LibraryDependency.compose)
    implementation(LibraryDependency.composeMaterial)
    implementation(LibraryDependency.composeActivity)
    implementation(LibraryDependency.composeNavigation)
    implementation(LibraryDependency.composeUI)
    implementation(LibraryDependency.composeTooling)


}
// Define lifeCycle dependencies  for testing, so they can be easily updated across feature modules
fun DependencyHandler.lifeCycleDependencies() {
    api(LibraryDependency.LIFECYCLEEXTENSIONS)
    api(LibraryDependency.COREKTX)
    api(LibraryDependency.LIFECYCLEViewModel)
    api(LibraryDependency.LIVEDATAKTX)


}
// Define di dependencies  for testing, so they can be easily updated across feature modules
fun DependencyHandler.diDependencies() {
    api(LibraryDependency.KOIN)
    api(LibraryDependency.KOIN_SCOPE)
    api(LibraryDependency.KOIN_VIEWMODEL)
}

// Define network dependencies  for testing, so they can be easily updated across feature modules
fun DependencyHandler.networkDependencies() {
    api(LibraryDependency.RETROFITCOROUTINESADAPTER)
    api(LibraryDependency.GSON)
    api(LibraryDependency.RETROFIT)
    api(LibraryDependency.RETROFITGSONADAPTER)
    api(LibraryDependency.HTTPLOGGER)
    api(LibraryDependency.coroutines_core)
    api(LibraryDependency.coroutines_android)

}

// Define room dependencies  for testing, so they can be easily updated across feature modules
fun DependencyHandler.localRoomDependencies() {
    kapt(LibraryDependency.roomCompiler)
    api(LibraryDependency.roomKtx)
    api(LibraryDependency.roomRunTime)
}


/*
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 * They are used here to provide above dependency syntax that mimics Gradle Kotlin DSL syntax in module\build.gradle.kts.kts files.
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)
