public class Main {

    private static int passed = 0;
    private static int total = 0;

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Run program with --demo");
        }
    }

    private static void runDemo() {

        // T1: Circle + VectorRenderer
        Circle circleVector =
                new Circle("circle-1", 2, new VectorRenderer());

        String resultT1 = circleVector.execute();

        check(
                "T1",
                "Circle + VectorRenderer",
                resultT1,
                "VECTOR circle radius=2"
        );


        // T2: Circle + RasterRenderer
        Circle circleRaster =
                new Circle("circle-2", 2, new RasterRenderer());

        String resultT2 = circleRaster.execute();

        check(
                "T2",
                "Circle + RasterRenderer",
                resultT2,
                "RASTER circle radius=2"
        );


        // T3: Square + VectorRenderer
        Square squareVector =
                new Square("square-1", 3, new VectorRenderer());

        String resultT3 = squareVector.execute();

        check(
                "T3",
                "Square + VectorRenderer",
                resultT3,
                "VECTOR square side=3"
        );


        // T4: Square + RasterRenderer
        Square squareRaster =
                new Square("square-2", 3, new RasterRenderer());

        String resultT4 = squareRaster.execute();

        check(
                "T4",
                "Square + RasterRenderer",
                resultT4,
                "RASTER square side=3"
        );


        // T5: Runtime switch on the same Circle object

        Circle switchCircle =
                new Circle("circle-switch", 2, new VectorRenderer());

        Shape originalReference = switchCircle;

        String originalId = switchCircle.getId();
        int originalRadius = switchCircle.getRadius();

        String before = switchCircle.execute();

        switchCircle.setImplementation(new RasterRenderer());

        Shape afterReference = switchCircle;

        String after = switchCircle.execute();

        boolean sameObject =
                originalReference == afterReference;

        boolean stateUnchanged =
                originalId.equals(switchCircle.getId())
                        && originalRadius == switchCircle.getRadius();

        boolean resultsCorrect =
                before.equals("VECTOR circle radius=2")
                        && after.equals("RASTER circle radius=2");

        boolean t5Passed =
                sameObject && stateUnchanged && resultsCorrect;

        total++;

        if (t5Passed) {
            passed++;
        }

        System.out.println(
                "T5 " + (t5Passed ? "PASS" : "FAIL")
                        + " | sameObject=" + sameObject
                        + " | stateUnchanged=" + stateUnchanged
        );

        System.out.println(
                " before=" + before
                        + " | after=" + after
        );


        System.out.println();
        System.out.println(
                "BASE SUMMARY: " + passed + "/" + total + " PASS"
        );
    }


    private static void check(
            String testId,
            String classes,
            String actual,
            String expected
    ) {

        total++;

        boolean success = actual.equals(expected);

        if (success) {
            passed++;
        }

        System.out.println(
                testId
                        + " "
                        + (success ? "PASS" : "FAIL")
                        + " | "
                        + classes
                        + " | result="
                        + actual
        );

        if (!success) {
            System.out.println(
                    " expected=" + expected
            );
        }
    }
}