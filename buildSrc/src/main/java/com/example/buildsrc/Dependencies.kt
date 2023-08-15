package com.example.buildsrc


object Versions {
    const val ktLint = "1.8.21"
    const val googleServices = "4.3.4"
}

object Retrofit{
    private const val retrofitVersion = "2.9.0"
    private const val okHttpLoggingInterceptorVersion = "4.9.0"

    const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpLoggingInterceptorVersion"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.1"
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLint}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"

    object Accompanist {
        const val version = "0.23.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
    }

    val retrofitLibraries = arrayListOf<String>().apply {
        add(Retrofit.retrofit)
        add(Retrofit.retrofitGson)
        add(Retrofit.okHttpLoggingInterceptor)
    }

    object Firebase {
        const val firebaseAuthVersion = "20.0.0"
        const val firebaseCommonVersion = "20.1.1"
        const val firebaseBoomVersion = "30.3.1"
        const val serviceAuthVersion = "18.1.0"

        const val firebaseAuth  = "com.google.firebase:firebase-auth-ktx"
        const val firebaseCommon  = "com.google.firebase:firebase-common-ktx:$firebaseCommonVersion"
        const val serviceAuth  = "com.google.android.gms:play-services-auth:$serviceAuthVersion"
        const val firestore = "com.google.firebase:firebase-firestore-ktx"
        const val firebaseBoom = "com.google.firebase:firebase-bom:$firebaseBoomVersion"
        const val firebaseAuthUI = "com.firebaseui:firebase-ui-auth:7.2.0"
    }

    object ConfigData {
        const val compileSdkVersion = 32
        const val minSdkVersion = 21
        const val targetSdkVersion = 32
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"

        object Coroutines {
            private const val version = "1.6.4"
            private const val coreVersion = "1.6.4"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coreVersion"
            const val playServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coreVersion"
        }
    }

    object AndroidX {
        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        }

        const val appcompat = "androidx.appcompat:appcompat:1.3.1"

        object Compose {
            const val snapshot = ""
            const val versionCompose = "1.2.1"
            const val version= "1.1.1"
            const val versionCompiler= "1.3.1"
            const val material3Version = "1.0.0-alpha13"
            const val navigationVersion = "2.5.3"
            const val hiltVersion = "1.0.0"
            const val hiltCompilerVersion = "1.0.0-alpha01"
            const val splashScreenVersion = "1.0.0-alpha02"


            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
            const val material = "androidx.compose.material3:material3:$material3Version"
            const val materialWindowSize = "androidx.compose.material3:material3-window-size-class:$material3Version"
            const val ui = "androidx.compose.ui:ui:$versionCompose"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val animation = "androidx.compose.animation:animation:$versionCompose"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$versionCompose"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltVersion"
            const val hiltCompiler = "androidx.hilt:hilt-compiler:$hiltCompilerVersion"
            const val splashScreen = "androidx.core:core-splashscreen:$splashScreenVersion"
        }

        object Lifecycle {
            private const val version = "2.4.0-rc01"
            private const val coreVersion = "1.8.0"
            private const val liveDataVersion = "2.6.0-alpha01'"
            private const val arch_version = "2.1.0"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"

            const val liveDataRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

            const val archCore =  "androidx.arch.core:core-testing:$arch_version"
            const val androidxCore = "androidx.core:core-ktx:$arch_version"
        }

        object Test {
            private const val version = "1.4.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"
            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object Hilt {
        private const val version = "2.46.1"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
    }

}

object Urls {
    const val mavenCentralSnapshotRepo = "https://oss.sonatype.org/content/repositories/snapshots/"
    const val composeSnapshotRepo = "https://androidx.dev/snapshots/builds/" +
            "${Libs.AndroidX.Compose.snapshot}/artifacts/repository/"
}
