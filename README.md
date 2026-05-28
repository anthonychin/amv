# AMV — Mobile Vector Calculator

An Android application for computing 2D vector operations in both Cartesian and Polar coordinate modes, with graphical output.

**Authors:** Anthony Chin, Andrew Walker

---

## Features

- **Vector Addition** — add two or three vectors
- **Dot Product** — compute the scalar product of two vectors
- **Cross Product** — compute the z-component of the 3D cross product of two 2D vectors
- **Cartesian mode** — enter vectors as (i, j) components
- **Polar mode** — enter vectors as (magnitude, degree) pairs; toggle with a button
- **Graph output** — result vector drawn on a canvas with labeled axes

---

## Operations

| Operation     | Cartesian output      | Polar output                        |
|---------------|-----------------------|-------------------------------------|
| Addition      | `xi + yj`             | `r Magnitude : θ Degree`            |
| Dot Product   | scalar value          | scalar value                        |
| Cross Product | `0i + 0j + zk`        | z-component: `Magnitude 0; Z: z`    |

Addition supports an optional third vector input field that appears when the mode is selected.

---

## Build

Requires Android SDK (API 19) and Gradle.

```bash
./gradlew assembleDebug
```

To run instrumentation tests on a connected device or emulator:

```bash
./gradlew connectedAndroidTest
```

---

## Project Structure

```
app/src/main/java/com/amv/anthonychin/mobilevectorcalculator/
├── amv.java          — Main Activity
├── Vector.java       — Cartesian 2D vector
└── PolarVector.java  — Polar 2D vector

app/src/androidTest/
├── TestVectorAddition.java
├── TestDotProduct.java
├── TestCrossProduct.java
├── TestPolarVectorAddition.java
├── TestPolarDotProduct.java
└── TestPolarCrossProduct.java
```

---

## Target Platform

- **Min / Target SDK:** API 19 (Android 4.4 KitKat)
- **Language:** Java
- **Build system:** Gradle
