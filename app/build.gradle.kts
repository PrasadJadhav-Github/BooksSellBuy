plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.bookssellbuy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bookssellbuy"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding =true
        dataBinding = true
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")

    // Material Design
    implementation ("com.google.android.material:material:1.3.0-alpha03")

    //firebase
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))

    implementation("com.google.firebase:firebase-auth")

    implementation ("androidx.appcompat:appcompat:1.4.0")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.5")
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    implementation ("androidx.recyclerview:recyclerview:1.2.1")

}