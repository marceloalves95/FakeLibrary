plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {

    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "br.com.fakelibrary"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Dependencies.kotlin_version}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Dependencies.kotlin_version}")
    implementation("androidx.core:core-ktx:${Dependencies.core_ktx_version}")
    implementation("androidx.appcompat:appcompat:${Dependencies.appcompat_version}")
    implementation("com.google.android.material:material:${Dependencies.material_version}")
    implementation("androidx.constraintlayout:constraintlayout:${Dependencies.constraint_layout_version}")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:${Dependencies.swipe_refresh_layout_version}")

    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Dependencies.lifecycle_version}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependencies.lifecycle_version}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.lifecycle_version}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Dependencies.retrofit_version}")
    implementation("com.squareup.retrofit2:converter-gson:${Dependencies.retrofit_version}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Dependencies.okhttp3_logging_interceptor}")

    //Glide
    kapt("com.github.bumptech.glide:compiler:${Dependencies.glide_version}")
    implementation("com.github.bumptech.glide:glide:${Dependencies.glide_version}")
    annotationProcessor("com.github.bumptech.glide:glide:${Dependencies.glide_version}")

    //Koin
    implementation("io.insert-koin:koin-android:${Dependencies.koin_version}")

    //Mockk
    testImplementation("io.mockk:mockk:${Dependencies.mockk_version}")
    androidTestImplementation("io.mockk:mockk-android:${Dependencies.mockk_version}")

    //Testes
    testImplementation("junit:junit:${Dependencies.test_junit_version}")
    testImplementation("io.insert-koin:koin-test:${Dependencies.koin_version}")
    androidTestImplementation("androidx.test.ext:junit:${Dependencies.test_ext_junit_version}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Dependencies.espresso_core_version}")

}