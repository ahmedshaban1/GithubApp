plugins {
    `kotlin-dsl`
    kotlin("kapt") version "1.3.21"
}

//The kotlin-dsl plugin requires a repository to be declared
repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        register("base-gradle-plugin") {
            id = "base-gradle-plugin"
            implementationClass = "base_plugin.BaseGradlePlugin"
        }
    }
}


dependencies {
    /* Depend on the android gradle plugin, since we want to access it in our plugin */
    implementation("com.android.tools.build:gradle:7.0.1")
    /* Depend on the kotlin plugin, since we want to access it in our plugin */
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
}
