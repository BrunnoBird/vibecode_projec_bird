plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.vibecodeprojecbird.core.testing"
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
    implementation(libs.junit)
    implementation(libs.kotlinx.coroutines.test)
}
