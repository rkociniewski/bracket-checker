[![version](https://img.shields.io/badge/version-1.0.1-yellow.svg)](https://semver.org)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.21-blueviolet?logo=kotlin)](https://kotlinlang.org/)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![Build](https://github.com/rkociniewski/bracket-checker/actions/workflows/main.yml/badge.svg)](https://github.com/rkociniewski/bracket-checker/actions/workflows/main.yml)
[![codecov](https://codecov.io/gh/rkociniewski/bracket-checker/branch/main/graph/badge.svg)](https://codecov.io/gh/rkociniewski/bracket-checker)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.1-blue?logo=gradle)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-greem.svg)](https://opensource.org/licenses/MIT)

# Bracket Balance Checker

A simple Kotlin utility to check whether a string contains **balanced brackets**.
Supports `()`, `[]`, and `{}`. Non-bracket characters are ignored by default.

## Features

- ✅ Checks for correct nesting and pairing of brackets
- ✅ Ignores all non-bracket characters
- ✅ Written in idiomatic Kotlin using `fold`
- ✅ Includes unit tests with JUnit 5 and parameterized cases

## Example

```kotlin
"([{}])".isBalanced()       // true
"function() { return []; }".isBalanced() // true
"([)]".isBalanced()         // false
"{[}".isBalanced()          // false
````

## Installation

This project uses Kotlin and can be run using any Kotlin-compatible build system.
To try it out:

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/bracket-checker.git
   cd bracket-checker
   ```

2. Run tests with Gradle:

   ```bash
   ./gradlew test
   ```

> Requires JDK 17+ and Gradle installed (or use the Gradle wrapper).

## Implementation

The core logic is implemented as a Kotlin **extension function**:

```kotlin
fun String.isBalanced(): Boolean
```

The function uses a functional approach (`fold`) to simulate a stack and validate bracket pairs.

### KDoc

```kotlin
/**
 * Checks if the string contains a balanced set of brackets.
 *
 * Supports (), [], and {}. Ignores all other characters.
 *
 * @receiver the string to check for balanced brackets
 * @return `true` if the brackets in the string are balanced, `false` otherwise
 */
fun String.isBalanced(): Boolean
```

## Testing

All edge cases are covered, including:

* Empty string
* Properly nested brackets
* Improperly ordered or unmatched brackets
* Strings with mixed content (text and brackets)

Tests are located in [`BracketsTest.kt`](src/test/kotlin/rk/powermilk/BracketsTest.kt) and use JUnit 5 with `@ParameterizedTest`.

---

## License

MIT
