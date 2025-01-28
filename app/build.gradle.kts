plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.final_application_2024"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.final_application_2024"
        minSdk = 24
        targetSdk = 35
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
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.legacy.support.v4)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Fragments
    implementation("androidx.fragment:fragment:1.8.5")
    implementation("androidx.fragment:fragment-ktx:1.8.5")

    // DataStore
    implementation("androidx.datastore:datastore:1.1.1")

    // DaggerHilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")

    // Navigation
    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:2.8.4")
    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:2.8.4")
    implementation("androidx.navigation:navigation-ui:2.8.4")
    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.8.4")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.4")
    // Navigation Fragment KTX
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.4")
    
    // CameraX
    // The following line is optional, as the core library is included indirectly by camera-camera2
    implementation("androidx.camera:camera-core:1.5.0-alpha04")
    implementation("androidx.camera:camera-camera2:1.5.0-alpha04")
    // If you want to additionally use the CameraX Lifecycle library
    implementation("androidx.camera:camera-lifecycle:1.5.0-alpha04")
    // If you want to additionally use the CameraX VideoCapture library
    implementation("androidx.camera:camera-video:1.5.0-alpha04")
    // If you want to additionally use the CameraX View class
    implementation("androidx.camera:camera-view:1.5.0-alpha04")
    // If you want to additionally add CameraX ML Kit Vision Integration
    implementation("androidx.camera:camera-mlkit-vision:1.5.0-alpha04")
    // If you want to additionally use the CameraX Extensions library
    implementation("androidx.camera:camera-extensions:1.5.0-alpha04")

    // Maps SDK for Android
    implementation("com.google.android.gms:play-services-maps:19.0.0")

    // WorkManager
    // (Java only)
    implementation("androidx.work:work-runtime:2.10.0")
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:2.10.0")
    // optional - RxJava2 support
    implementation("androidx.work:work-rxjava2:2.10.0")
    // optional - GCMNetworkManager support
    implementation("androidx.work:work-gcm:2.10.0")
    // optional - Test helpers
    androidTestImplementation("androidx.work:work-testing:2.10.0")
    // optional - Multiprocess support
    implementation("androidx.work:work-multiprocess:2.10.0")
}

kapt {
    correctErrorTypes = true
}

secrets {
    // To add your Maps API key to this project:
    // 1. If the secrets.properties file does not exist, create it in the same folder as the local.properties file.
    // 2. Add this line, where YOUR_API_KEY is your API key:
    //        MAPS_API_KEY=YOUR_API_KEY
    propertiesFileName = "secrets.properties"

    // A properties file containing default secret values. This file can be
    // checked in version control.
    defaultPropertiesFileName = "local.defaults.properties"

    // Configure which keys should be ignored by the plugin by providing regular expressions.
    // "sdk.dir" is ignored by default.
    ignoreList.add("keyToIgnore") // Ignore the key "keyToIgnore"
    ignoreList.add("sdk.*")       // Ignore all keys matching the regexp "sdk.*"
}