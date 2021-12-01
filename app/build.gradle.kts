plugins {
    id(Plugins.android_application)
    id(Plugins.kotlin_android)
    id(Plugins.kotlin_kapt)
    id(Plugins.kotlin_parcelize)
}

android {

    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner

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

    implementation(Dependencies.kotlin)
    implementation(Dependencies.kotlinLib)
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraint_layout)
    implementation(Dependencies.swipe_refresh_layout)

    //Lifecycle
    implementation(Dependencies.lifecycle_livedata)
    implementation(Dependencies.lifecycle_viewmodel)
    implementation(Dependencies.lifecycle_runtime)

    //Facebook Shimmer
    implementation(Dependencies.facebook_shimmer)
    //Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.converter_gson)
    implementation(Dependencies.okhttp3_logging_interceptor)

    //Glide
    kapt(Dependencies.glide_compiler)
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glide)

    //Koin
    implementation(Dependencies.koin)

    //Mockk
    testImplementation(Dependencies.mockk)
    androidTestImplementation(Dependencies.mockk_android)

    //Testes
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.koin_test)
    androidTestImplementation(Dependencies.ext_junit)
    androidTestImplementation(Dependencies.espresso_core)

}