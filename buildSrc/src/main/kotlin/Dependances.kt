/*
*
* this class holding all
*  (AndroidConfig ,BuildType
*  CoreVersion,GradlePluginId,GradlePluginId,
*  GradleClasspath....etc)
*
* */
object AndroidConfig {
    const val COMPILE_SDK_VERSION = 30
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

interface BuildType {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "release"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
}

object CoreVersion {
    const val KOTLIN = "1.5.30"
    const val NAVIGATION = "2.3.5"
    const val ANDROID_GRADLE = "3.5.3"
    const val KTLINT_GRADLE = "10.0.0"
    const val KTLINT = "0.34.2"
    const val DETEKT = "1.0.0"
    const val KAPT = "1.3.71"
}

object GradlePluginId {
    const val ANDROID_APP = "com.android.application"
    const val ANDROID_LIB = "com.android.library"
    const val ANDROID = "kotlin-android"
    const val SAFE_ARGS = "androidx.navigation.safeargs"
    const val BASE_GRADLE_PLUGIN = "base-gradle-plugin"
    const val KTLINT_GRADLE = "org.jlleitschuh.gradle.ktlint"
    const val KTLINT_MAVEN = "https://plugins.gradle.org/m2/"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KAPT = "kotlin-kapt"
}

object GradleClasspath {
    const val KOTLIN_PlUGIN = "gradle-plugin"
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${CoreVersion.ANDROID_GRADLE}"
    const val SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${CoreVersion.NAVIGATION}"
    const val KTLINT_CLASSPATH = "org.jlleitschuh.gradle:ktlint-gradle:${CoreVersion.KTLINT_GRADLE}"
}


object LibraryDependency {
    object Version {
        const val SUPPORT_LIB = "1.3.1"
        const val MATERIAL = "1.4.0"
        const val CONSTRAINT = "2.1.0"
        const val KOIN = "2.2.3"
        val kotlin = "1.3.21"
        val gradle = "3.3.2"
        const val coreKtx = "1.1.0-alpha04"
        const val retrofit = "2.6.2"
        const val retrofitCoroutines = "0.9.2"
        const val retrofitGson = "2.6.2"
        const val gson = "2.8.5"
        const val okHttp = "3.12.1"
        const val coroutines = "1.1.1"
        const val lifecycle = "2.1.0-alpha04"
        const val livedata_version = "2.2.0-rc02"
        const val room = "2.3.0"
        const val recyclerview = "1.0.0"
        const val archCoreTest = "2.1.0"
        const val mockk = "1.12.0"
        const val coroutines_android_version = "1.5.0"
        const val COROUTINESTESTING = "1.3.2"
        const val PICASSO = "2.71828"
        const val ROUNDED_IMAGE = "2.3.0"
        const val androidx_ext_junit = "1.1.1"
        const val compose = "1.0.1"
        const val composeActivity = "1.3.1"
        const val composeNavigation = "2.4.0-alpha06"

    }

    const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.SUPPORT_LIB}"
    const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT}"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${CoreVersion.NAVIGATION}"

    const val ROUNDED_IMAGE_VIEW = "com.makeramen:roundedimageview:${Version.ROUNDED_IMAGE}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${CoreVersion.NAVIGATION}"
    const val KOIN = "io.insert-koin:koin-android:${Version.KOIN}"
    const val KOIN_VIEWMODEL = "io.insert-koin:koin-androidx-viewmodel:${Version.KOIN}"
    const val KOIN_SCOPE = "io.insert-koin:koin-androidx-scope:${Version.KOIN}"
    const val PICASSO = "com.squareup.picasso:picasso:${Version.PICASSO}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Version.recyclerview}"

    const val COREKTX = "androidx.core:core-ktx:${Version.coreKtx}"
    const val LIFECYCLEViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val LIFECYCLEEXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val LIVEDATAKTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.livedata_version}"


    //retrofit
    const val RETROFITCOROUTINESADAPTER =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Version.retrofitCoroutines}"
    const val GSON = "com.google.code.gson:gson:${Version.gson}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val RETROFITGSONADAPTER = "com.squareup.retrofit2:converter-gson:${Version.retrofitGson}"
    const val HTTPLOGGER = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"

    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines_android_version}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines_android_version}"

    //room

    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomRunTime = "androidx.room:room-runtime:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"

    //testing mockk

    const val MOCKkANDROIDTESTING = "io.mockk:mockk-android:${Version.mockk}"
    const val MOCKKTESTING = "io.mockk:mockk:${Version.mockk}"

    const val COROUTINESTESTING =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINESTESTING}"
    const val LIFECYCLETESTING = "androidx.arch.core:core-testing:${Version.archCoreTest}"

    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    val compose = "androidx.compose.ui:ui:${Version.compose}"
    val composeActivity =  "androidx.activity:activity-compose:${Version.composeActivity}"
    val composeUI = "androidx.compose.ui:ui:${Version.compose}"
    val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    val composeNavigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"


}

object ModulesDependency {
    const val COMMON = ":libraries:common"
    const val REMOTE = ":data:remote"
    const val MODEL = ":data:model"
    const val LOCAL = ":data:local"

}

object FeaturesDependency {
    private const val prefix = ":features:"
    const val search = "${prefix}search"
}

object TestLibraryDependency {
    object Version {
        const val JUNIT = "4.12"
        const val JUNIT_ANDROID = "1.1.1"
        const val ESPRESSO = "3.2.0"
        const val androidx_ext_junit = "1.1.1"
        const val androidx_testing = "1.2.0"
        const val testing_core = "1.3.0-alpha03"
        const val barista = "4.1.0"
        const val fragments_testing = "1.2.0-rc03"
        const val core = "2.0.0"
    }

    const val JUNIT = "junit:junit:${Version.JUNIT}"
    const val JUNIT_ANDROID = "androidx.test.ext:junit:${Version.JUNIT_ANDROID}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Version.ESPRESSO}"
    const val KOIN = "io.insert-koin:koin-test:${LibraryDependency.Version.KOIN}"

    val testandroidx_junit = "androidx.test.ext:junit:${Version.androidx_ext_junit}"
    val testandroidx_runner = "androidx.test:runner:${Version.androidx_testing}"
    val testandroidx_rules = "androidx.test:rules:${Version.androidx_testing}"
    val fragments_testing = "androidx.fragment:fragment-testing:${Version.fragments_testing}"
    val androidx_testing_core = "androidx.test:core:${Version.testing_core}"
    val barista =
        "com.adevinta.android:barista:${Version.barista}"
    val arc_core = "androidx.arch.core:core-testing:${Version.core}"
}