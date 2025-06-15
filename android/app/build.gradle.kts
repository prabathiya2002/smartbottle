plugins {
    id("com.android.application")
    id("kotlin-android")

    // Flutter’s Gradle plugin (must stay after the Android/Kotlin IDs)
    id("dev.flutter.flutter-gradle-plugin")

    // Google services Gradle plugin – needed for Firebase
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.smartbottle"

    // Values supplied by Flutter’s wrapper
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    defaultConfig {
        applicationId = "com.example.smartbottle"

        // 👉 Firebase Auth 23.x requires at least API 23
        minSdk = 23

        targetSdk   = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions { jvmTarget = "11" }

    buildTypes {
        release {
            // TODO: replace with your release keystore when ready
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    // Do not change – this tells Gradle where the Dart sources live
    source = "../.."
}

dependencies {
    // ① Import the Firebase BoM (Bill of Materials)
    implementation(platform("com.google.firebase:firebase-bom:33.15.0"))

    // ② Firebase libraries you actually need — NO VERSIONS when using the BoM
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-storage")
    // implementation("com.google.firebase:firebase-messaging")
    // implementation("com.google.firebase:firebase-analytics")

    // ③ Other app dependencies (state‑management, Bluetooth, etc.) go here
    // implementation("com.group.id:library:x.y.z")
}
