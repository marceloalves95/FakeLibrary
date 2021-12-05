# FakeLibrary

Esse projeto está usando os seguintes itens:

- Arquitetura Clean Architeture.
- Gradle KTS
- Testes Unitários com Mockk

Primeiro, crie três pacotes com cada camada do Clean Architecture (data, domain e presentation).

### Criando o diretório buildSrc

Esse diretório é responsável pela declaração das dependências do projeto e pelo uso do `kotlin-dsl`.

Primeiro, mude para a visualização de projeto. Depois aperte com o botão direito em cima do projeto e faça `New > Diretory > nomeie o diretório para buildSrc`. Crie um arquivo dentro desse diretório chamado `build.gradle.kts` (`New > File > build.gradle.kts`) . Nesse novo arquivo escreva as seguintes linhas:

```kotlin
plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}
```

Após isso, sincronize o projeto. 

Crie um diretório dentro de `buildSrc`. Selecione a opção  `New > Diretory > escolha a opção src\main\kotlin`

Dentro do diretório `kotlin`, crie os objetos que vc irá usar no projeto. Eu crie 4 para cada finalidade:

**Object AppConfig**

```kotlin
object AppConfig {
    const val applicationId = "br.com.fakelibrary"
    const val compileSdkVersion = 31
    const val minSdkVersion = 25
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}
```

**Object Dependencies**

```kotlin
object Dependencies {

    const val gradle="com.android.tools.build:gradle:${Version.gradle_version}"
    const val gradle_plugin="org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.gradle_plugin_version}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin_version}"
    const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin_version}"
    const val core_ktx="androidx.core:core-ktx:${Version.core_ktx_version}"
    const val appcompat="androidx.appcompat:appcompat:${Version.appcompat_version}"
    const val material="com.google.android.material:material:${Version.material_version}"
    const val constraint_layout="androidx.constraintlayout:constraintlayout:${Version.constraint_layout_version}"
    const val swipe_refresh_layout="androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipe_refresh_layout_version}"

    const val lifecycle_livedata="androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle_version}"
    const val lifecycle_viewmodel="androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle_version}"
    const val lifecycle_runtime="androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle_version}"

    const val facebook_shimmer="com.facebook.shimmer:shimmer:${Version.facebook_shimmer_version}"
    const val retrofit="com.squareup.retrofit2:retrofit:${Version.retrofit_version}"
    const val converter_gson="com.squareup.retrofit2:converter-gson:${Version.retrofit_version}"
    const val okhttp3_logging_interceptor= "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3_logging_interceptor_version}"
    const val glide_compiler="com.github.bumptech.glide:compiler:${Version.glide_version}"
    const val glide="com.github.bumptech.glide:glide:${Version.glide_version}"
    const val koin= "io.insert-koin:koin-android:${Version.koin_version}"
    const val mockk="io.mockk:mockk:${Version.mockk_version}"
    const val mockk_android="io.mockk:mockk-android:${Version.mockk_version}"

    const val koin_test="io.insert-koin:koin-test:${Version.koin_version}"
    const val junit="junit:junit:${Version.junit_version}"
    const val ext_junit="androidx.test.ext:junit:${Version.ext_junit_version}"
    const val espresso_core="androidx.test.espresso:espresso-core:${Version.espresso_core_version}"

}
```

**Object Plugins**

```kotlin
object Plugins {
    const val android_application="com.android.application"
    const val kotlin_android="kotlin-android"
    const val kotlin_kapt="kotlin-kapt"
    const val kotlin_parcelize="kotlin-parcelize"
}
```

**Object Version**

```kotlin
object Version {

    const val gradle_version="7.0.3"
    const val gradle_plugin_version="1.6.0"

    const val kotlin_version = "1.6.0"
    const val core_ktx_version="1.7.0"
    const val appcompat_version="1.4.0"
    const val material_version="1.4.0"
    const val constraint_layout_version="2.1.2"
    const val swipe_refresh_layout_version="1.1.0"

    const val lifecycle_version="2.4.0"

    const val facebook_shimmer_version="0.1.0@aar"
    const val retrofit_version="2.9.0"
    const val okhttp3_logging_interceptor_version= "5.0.0-alpha.3"
    const val glide_version="4.12.0"
    const val koin_version= "3.1.4"
    const val mockk_version="1.12.1"

    const val junit_version="4.13.2"
    const val ext_junit_version="1.1.3"
    const val espresso_core_version="3.4.0"

}
```

####  Transformando a linguagem Groove (Gradle) em Kotlin KTS 

Abra o arquivo `settings.gradle` e renomeie para `settings.gradle.kts`e depois configure o arquivo para a linguagem KTS.

```kotlin
rootProject.name = "FakeLibrary"
include(":app")
```

Abra o `build.gradle` do projeto e renomeie para `build.gradle.kts`. Depois configure o arquivo para a linguagem KTS

```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.gradle)
        classpath(Dependencies.gradle_plugin)
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}

```

Abra o `build.gradle` do projeto e renomeie para `build.gradle.kts`. Depois configure o arquivo para a linguagem KTS

```kotlin
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
```


