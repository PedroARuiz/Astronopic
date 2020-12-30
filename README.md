# Astronopic

Astronopic is an application which shows a new picture everyday from [NASA API](https://api.nasa.gov/) using [Kotlin Multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html)

## Architecture
It's implements a clean architecture by layers (domain, data and presentation) which all of them are shared between Android and iOS code.
Also, from the presentation layer a MVVM pattern has been working.

Into this three layers there are some gradle modules:
- Domain
  - model
  - repository
  - useCase
- Data
  - repositoryImpl
  - local
    - db
    - localDataSource
  - remote
    - dto
    - service
    - remoteDataSource
- Presentation
  - common
  - apod

## Dependencies

- [Kotlin coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Ktor](https://ktor.io/docs/clients-index.html)
- [Koin](https://insert-koin.io/)
- [SqlDelight](https://cashapp.github.io/sqldelight/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose) (Android)

### iOS not available yet
