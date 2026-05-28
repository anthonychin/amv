# CLAUDE.md — AMV: Mobile Vector Calculator

## Project Overview

AMV (Anthony Mobile Vector) is an Android application for computing 2D vector operations. Users can work in either **Cartesian** (i, j components) or **Polar** (magnitude, degree) coordinate modes. Results are displayed numerically and drawn on a canvas graph.

**Authors:** Anthony Chin, Andrew Walker

---

## Architecture

```
app/src/main/java/com/amv/anthonychin/mobilevectorcalculator/
├── amv.java          — Main Activity: UI, input parsing, computation dispatch, canvas drawing
├── Vector.java       — Cartesian 2D vector (x, y); add, dot, cross operations
└── PolarVector.java  — Polar 2D vector (r, θ°); polar↔Cartesian conversion, add, dot, cross
```

### Core Classes

**`Vector`** — Cartesian representation
- `add(Vector v1)` — adds two vectors
- `add(Vector v1, Vector v2)` — adds three vectors
- `dot(Vector v1)` — scalar dot product
- `cross(Vector v1)` — returns `(0, k)` where k is the z-component of the 3D cross product

**`PolarVector`** — Polar representation (magnitude r, angle θ in degrees)
- `polar2cart(PolarVector v)` — converts to Cartesian `Vector`
- `cart2polar(Vector v)` — converts from Cartesian `Vector`
- `add`, `dot`, `cross` — internally converts to Cartesian, computes, converts back

**`amv` (Activity)**
- Tracks `typeOfComputation` (1=add, 2=dot, 3=cross) and `polar` flag
- Toggle button switches label text between "i/j" and "Magnitude/Degree"
- Third vector input pair shown only for addition; hidden for dot/cross
- Canvas draws result vector with x/y axes centered at (500, 500), 50px per unit

---

## Operations

| Mode     | Addition (2 or 3 vectors) | Dot Product | Cross Product |
|----------|--------------------------|-------------|---------------|
| Cartesian | `xi + yj`               | scalar      | `0i + 0j + zk` |
| Polar    | `r Magnitude : θ Degree` | scalar      | z-component only |

---

## Build

This is a standard Android Gradle project targeting **API 19** (KitKat).

```bash
# Build debug APK
./gradlew assembleDebug

# Run instrumentation tests (requires connected device or emulator)
./gradlew connectedAndroidTest
```

**compileSdkVersion / minSdkVersion / targetSdkVersion:** 19  
**Build tools:** 19.1.0

---

## Tests

Android instrumentation tests live in:

```
app/src/androidTest/java/com/amv/anthonychin/mobilevectorcalculator/
├── TestVectorAddition.java
├── TestDotProduct.java
├── TestCrossProduct.java
├── TestPolarVectorAddition.java
├── TestPolarDotProduct.java
└── TestPolarCrossProduct.java
```

Tests extend `InstrumentationTestCase` and cover valid inputs, boundary values (e.g., `Double.MAX_VALUE`), and both 2-vector and 3-vector addition variants.

---

## Key Constants

- `PRECISION = 1E-5` — threshold for treating a component as zero (used in angle computation and axis-alignment detection)
- Canvas axes drawn at fixed pixel coordinates (500, 500 center); vectors scaled at 50px per unit

---

## Package

`com.amv.anthonychin.mobilevectorcalculator`
