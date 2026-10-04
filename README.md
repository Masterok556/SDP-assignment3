# Assignment 3 - Bridge Pattern

Topic: A - Drawing
Base commit: 63a6a1e43f6ed11b45b4502b2512083f7e30dc1e

## Role Map

| Role | Class | Source |
|---|---|---|
| Abstraction | Shape | src/Shape.java |
| A1 | Circle | src/Circle.java |
| A2 | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| I1 | VectorRenderer | src/VectorRenderer.java |
| I2 | RasterRenderer | src/RasterRenderer.java |
| I3 | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |

## Bridge Structure

The `Shape` abstraction stores a reference of type `Renderer`.

- Bridge field: `Shape.renderer`
- Main operation: `execute()`
- Runtime replacement: `setImplementation(Renderer renderer)`
- Runtime switch demonstration: T5 in `Main.java`

## Build

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

## Run
```bash
java -cp out Main --demo
```

## Expected Results
T1 - Circle + VectorRenderer
Expected: `VECTOR circle radius=2`

T2 - Circle + RasterRenderer
Expected: `RASTER circle radius=2`

T3 - Square + VectorRenderer
Expected: `VECTOR square side=3`

T4 - Square + RasterRenderer
Expected: `RASTER square side=3`

T5 - Runtime switch
The same Circle object changes from VectorRenderer to RasterRenderer.
Object identity, ID and radius remain unchanged.

T6 - Circle + AsciiRenderer
Expected: `ASCII circle radius=2`

T7 - Square + AsciiRenderer
Expected: `ASCII square side=3`

Expected summary:
`SUMMARY: 7/7 PASS`
