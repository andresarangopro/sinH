import com.example.buildsrc.Libs
import com.example.buildsrc.implementationOwn

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.logogenia"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.logogenia"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (Libs.Kotlin.Coroutines.android)


    implementation (Libs.Accompanist.insets)
    implementation (Libs.AndroidX.Activity.activityCompose)
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.AndroidX.Compose.splashScreen)
    implementation (Libs.AndroidX.Compose.runtime)
    implementation (Libs.AndroidX.Compose.runtimeLiveData)
    implementation (Libs.AndroidX.Compose.material)
    implementation (Libs.AndroidX.Compose.foundation)
    implementation (Libs.AndroidX.Compose.layout)
    implementation (Libs.AndroidX.Compose.animation)
    implementation (Libs.AndroidX.Compose.toolingPreview)
    implementation (Libs.AndroidX.Compose.ui)
    implementation (Libs.AndroidX.Compose.navigation)
    implementation (Libs.AndroidX.Compose.materialWindowSize)
    implementation (Libs.AndroidX.Compose.hiltNavigationCompose)

    implementation (platform(Libs.Firebase.firebaseCommon))
    implementation (Libs.Firebase.serviceAuth)
    implementation (Libs.Firebase.firebaseAuth)
    implementation (Libs.Firebase.firebaseAuthUI)
    implementation (Libs.Firebase.firestore)
    implementation (Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation (Libs.Hilt.android)
    implementation (Libs.AndroidX.Lifecycle.liveData)


    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.core:core-ktx:1.12.0-rc01")
    implementationOwn(Libs.retrofitLibraries)

    testImplementation(Libs.JUnit.junit)

    debugImplementation (Libs.AndroidX.Compose.tooling)
    kapt (Libs.Hilt.compiler)
    kapt (Libs.AndroidX.Compose.hiltCompiler)

    debugImplementation (Libs.AndroidX.Compose.uiTestManifest)

    androidTestImplementation (Libs.JUnit.junit)
    androidTestImplementation (Libs.AndroidX.Test.core)
    androidTestImplementation (Libs.AndroidX.Test.runner)
    androidTestImplementation (Libs.AndroidX.Test.rules)
    androidTestImplementation (Libs.AndroidX.Test.espressoCore)
    androidTestImplementation (Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation (Libs.Kotlin.Coroutines.test)
    androidTestImplementation (Libs.AndroidX.Compose.uiTest)
    androidTestImplementation (Libs.Hilt.testing)
    androidTestImplementation (Libs.Hilt.android)
    kaptAndroidTest (Libs.Hilt.compiler)
    implementation("com.squareup:javapoet:1.13.0") // <-- added this
    // Glide
    //implementation 'com.github.bumptech.glide:glide:3.7.0'

    /*

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")*/
}