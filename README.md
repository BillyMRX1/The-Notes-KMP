# Note Application (Kotlin MUltiplatform)

This is a Note application built using Kotlin Multiplatform (KMP). The application follows clean architecture and MVVM (Model-View-ViewModel) patterns to ensure a scalable, maintainable, and testable codebase. The app allows users to create, edit, and view notes across multiple platforms.

## Features

- Create and edit notes
- View a list of saved notes
- Cross-platform compatibility (Android and iOS)
- MVVM architecture
- Room database for data persistence on Android & IOS
- Jetpack Compose for UI on both Android and iOS

## Architecture

The application is structured following the clean architecture principles:

1. **Domain Layer**: Contains the business logic of the application. This layer is platform-independent.
2. **Data Layer**: Responsible for data management. It includes repositories and data sources (e.g., Room database).
3. **Presentation Layer**: Consists of ViewModels and UI components.

## Screens

### HomePage

- Displays a list of notes saved in the Room database.
- Allows navigation to the CreateNote screen for creating a new note or editing an existing one.

### CreateNote

- Provides a form to create or edit a note.
- Saves the note to the Room database upon submission.

## Dependencies

The project uses the following libraries:

- Kotlin Multiplatform
- Jetpack Compose
- Room Database
- Kotlinx Serialization
- Koin (for dependency injection)
- KSP (Kotlin Symbol Processing)
- Cocoapods (For IOS)
- Kottie (Lottie Alternatives for KMP)
  source: https://github.com/ismai117/kottie

## Setup

### Prerequisites

- Android Studio
- Xcode (for iOS development)

### Clone the Repository

```bash
git clone https://github.com/BillyMRX1/The-Notes-KMP.git
```

### Open in Android Studio
1. Open Android Studio.
2. Select "Open an existing project".
3. Navigate to the cloned repository and select it.
4. Let Android Studio configure the project.

### Run on Android
1. Connect an Android device or start an Android emulator.
2. In Android Studio, select the app module.
3. Click on the Run button.

### Run on iOS
1. Install Cocoapods (if you already have cocoapods, you can skip to step number 2)
```bash
sudo gem install cocoapods
```
2. Initialize CocoaPods in the iOS project
```bash
cd iosApp
pod init
```
3. Edit the Podfile and Add Lottie Dependencies (Required for Kottie to works)
```bash
# Uncomment the next line to define a global platform for your project
# platform :ios, '9.0'

target 'iosApp' do
  # Comment the next line if you don't want to use dynamic frameworks
  use_frameworks!

  # Pods for iosApp
  pod 'lottie-ios', '~> 4.4.3'

end
```
4. Install the Pods
```bash
pod install
```
6. Open the iosApp.xcworkspace file in Xcode
7. Run the project on the iOS simulator

## Contact
If you have any questions or suggestions, feel free to reach out to brilianadeputra@gmail.com

## Kotlin Mutiplatform
If you want to learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html).
