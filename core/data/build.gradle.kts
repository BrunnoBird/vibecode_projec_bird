plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.vibecodeprojecbird.core.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 28
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(project(":core:common"))
}
