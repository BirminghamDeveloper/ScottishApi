\# ScottishApi App (Technical Assessment)

&nbsp;

This project is an Android application built to demonstrate modern Android development practices. It fetches and displays a list of comments and user details from the \[JSONPlaceholder API](https://jsonplaceholder.typicode.com/).

&nbsp;

The app follows \*\*Clean Architecture\*\* principles and is built using \*\*Jetpack Compose\*\* for the UI, \*\*Hilt\*\* for dependency injection, and \*\*Retrofit\*\* for networking. It includes unit tests for the Data, Domain, and Presentation layers.

&nbsp;

\## Table of Contents

&nbsp;

\- \[Architecture](#architecture)

\- \[Tech Stack \& Libraries](#tech-stack--libraries)

\- \[Features](#features)

\- \[Handling Configuration Changes](#handling-configuration-changes)

\- \[Setup](#setup)

\- \[Unit Testing](#unit-testing)

\- \[Screenshots](#screenshots)

\- \[Contact](#contact)

&nbsp;

\## Architecture

&nbsp;

The project strictly follows \*\*Clean Architecture\*\* with a \*\*MVVM\*\* pattern, separating concerns into three distinct layers:

&nbsp;

1\.  \*\*Domain Layer (Kotlin Pure)\*\*:

&nbsp;   - Contains \*\*Entities\*\* (Data classes like `Comment`).

&nbsp;   - Defines \*\*Repository Interfaces\*\*.

&nbsp;   - Contains \*\*Use Cases\*\* (e.g., `GetAllCommentsUseCase`) which encapsulate business logic (such as sorting comments alphabetically).

&nbsp;

2\.  \*\*Data Layer\*\*:

&nbsp;   - Manages network operations using \*\*Retrofit\*\*.

&nbsp;   - Implements Repository interfaces.

&nbsp;   - Maps \*\*DTOs\*\* (Data Transfer Objects) to Domain Entities using Mappers.

&nbsp;

3\.  \*\*Presentation Layer (App)\*\*:

&nbsp;   - \*\*Jetpack Compose\*\*: For building declarative UI.

&nbsp;   - \*\*ViewModels\*\*: Manages UI state using `StateFlow` / `MutableState`.

&nbsp;   - \*\*Hilt\*\*: Injects dependencies (UseCases) into ViewModels.

&nbsp;

\## Tech Stack \& Libraries

&nbsp;

\- \*\*Language\*\*: \[Kotlin](https://kotlinlang.org/)

\- \*\*UI Toolkit\*\*: \[Jetpack Compose](https://developer.android.com/jetpack/compose)

\- \*\*Dependency Injection\*\*: \[Hilt](https://dagger.dev/hilt/)

\- \*\*Networking\*\*: \[Retrofit](https://square.github.io/retrofit/) \& \[Gson](https://github.com/google/gson)

\- \*\*Concurrency\*\*: \[Coroutines](https://developer.android.com/kotlin/coroutines) \& \[Flow](https://developer.android.com/kotlin/flow)

\- \*\*Navigation\*\*: \[Compose Navigation](https://developer.android.com/guide/navigation/navigation-compose)

\- \*\*Testing\*\*:

&nbsp;   - \[JUnit 4](https://junit.org/junit4/): Standard unit testing framework.

&nbsp;   - \[MockK](https://mockk.io/): For creating mocks in Kotlin.

&nbsp;   - \[Coroutines Test](https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-test): For testing suspend functions and flows.

&nbsp;

\## Features

&nbsp;

\- \*\*Comments List\*\*: Fetches a list of comments from the API.

\- \*\*Sorting\*\*: Automatically sorts comments alphabetically by body content.

\- \*\*Detail View\*\*: Shows detailed information for a specific comment, including the associated User data.

\- \*\*State Management\*\*: Handles Loading, Success, and Error states (e.g., Network failures).

\- \*\*Navigation\*\*: Seamless transition between the List screen and Details screen.

&nbsp;

\## Handling Configuration Changes

&nbsp;

The application robustly handles configuration changes (such as device rotation) using \*\*Jetpack ViewModel\*\*.

&nbsp;

\- \*\*Lifecycle Awareness\*\*: The `CommentViewModel` is lifecycle-aware and survives the destruction and recreation of the Activity during rotation.

\- \*\*State Persistence\*\*: The UI state is held in a `MutableState` (or `StateFlow`) within the ViewModel. When the screen rotates:

&nbsp;   1. The Activity is destroyed.

&nbsp;   2. The ViewModel instance is \*\*retained\*\* in memory.

&nbsp;   3. The Activity is recreated and reconnects to the \*existing\* ViewModel.

&nbsp;   4. The UI immediately renders the existing data without re-fetching from the network, ensuring a smooth user experience.

&nbsp;

\## Setup

&nbsp;

To run this project:

&nbsp;

1\.  \*\*Clone the repository\*\*:

&nbsp;   ```bash

&nbsp;   git clone \[https://github.com/BirminghamDeveloper/ScottishApi.git](https://github.com/BirminghamDeveloper/ScottishApi.git)

&nbsp;   cd ScottishAPI

&nbsp;   ```

&nbsp;

2\.  \*\*Open in Android Studio\*\*:

&nbsp;   - Open Android Studio and select \*\*Open\*\*.

&nbsp;   - Navigate to the cloned directory.

&nbsp;

3\.  \*\*Sync \& Build\*\*:

&nbsp;   - Wait for Gradle to sync dependencies.

&nbsp;   - Select an emulator or physical device (Min SDK 24).

&nbsp;   - Click \*\*Run\*\*.

&nbsp;

\## Unit Testing

&nbsp;

This project emphasizes testing across all layers.

&nbsp;

\- \*\*Data Layer\*\*: Tests Mappers (DTO to Entity) and JSON parsing.

\- \*\*Domain Layer\*\*: Tests Use Cases to ensure business logic (like sorting) works correctly.

\- \*\*Presentation Layer\*\*: Tests ViewModels to ensure UI State updates correctly based on UseCase results.

&nbsp;

To run the tests:

1\.  Right-click on the `com.example` package in the `(test)` directory of any module (app, data, domain).

2\.  Select \*\*Run Tests\*\*.

&nbsp;

\## Screenshots

&nbsp;

| List Screen | Detail Screen |

|:---:|:---:|

<img width="416" height="921" alt="del 1" src="https://github.com/user-attachments/assets/1aaa80a0-e530-49c2-801a-d99a80a59ff8" /> | <img width="415" height="931" alt="del 2" src="https://github.com/user-attachments/assets/adc701ec-dd7f-4555-a8cf-18d055e5c3cc" />







&nbsp;

\## Contact

&nbsp;

\- \*\*Developer\*\*: Mustafa Sharif

\- \*\*Email\*\*: \[mustafa9sharif@gmail.com](mailto:mustafa9sharif@gmail.com)

\- \*\*GitHub\*\*: \[Mustafa Sharif](https://github.com/BirminghamDeveloper)



