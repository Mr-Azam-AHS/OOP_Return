import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.reflect.Field;

public class OOP_Tests {

    // TOLERANCE for double comparisons (handles tiny floating point precision
    // errors)
    private static final double TOLERANCE = 0.001;

    // --- Helper Method to Access Private Fields ---
    private Object getPrivateField(Object instance, String fieldName) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true); // Unlock private field
            return field.get(instance);
        } catch (Exception e) {
            throw new RuntimeException("Could not access field: " + fieldName, e);
        }
    }

    // ==========================================
    // TRIANGLE TESTS
    // ==========================================
    @Test
    public void testTriangle() {
        Triangle test = new Triangle();

        // Test Case: 3-4-5 Triangle
        test.setSides(3, 4, 5);
        test.calcPerimeter();
        test.calcArea();

        double actualPerimeter = (double) getPrivateField(test, "perimeter");
        double actualArea = (double) getPrivateField(test, "theArea");

        assertEquals("Triangle Perimeter (3,4,5) incorrect", 12.0, actualPerimeter, TOLERANCE);
        assertEquals("Triangle Area (3,4,5) incorrect", 6.0, actualArea, TOLERANCE);
    }

    // ==========================================
    // DISTANCE TESTS
    // ==========================================
    @Test
    public void testDistance() {
        Distance test = new Distance();

        // Test Case: (0,0) to (3,4) -> Distance should be 5
        test.setCoordinates(0, 0, 3, 4);
        test.calcDistance();

        double actualDist = (double) getPrivateField(test, "distance");

        assertEquals("Distance between (0,0) and (3,4) incorrect", 5.0, actualDist, TOLERANCE);

        // Test Case: (1,1) to (2,2) -> Distance sqrt(2) approx 1.414
        test.setCoordinates(1, 1, 2, 2);
        test.calcDistance();
        actualDist = (double) getPrivateField(test, "distance");

        assertEquals("Distance between (1,1) and (2,2) incorrect", 1.414, actualDist, TOLERANCE);
    }

    // ==========================================
    // MILES PER HOUR TESTS
    // ==========================================
    @Test
    public void testMilesPerHour() {
        MilesPerHour test = new MilesPerHour();

        // Test Case: 100 miles in 2 hours 0 mins
        test.setNums(100, 2, 0);
        test.calcMPH();

        double actualMPH = (double) getPrivateField(test, "mph");
        assertEquals("MPH for 100mi / 2hr incorrect", 50.0, actualMPH, TOLERANCE);

        // Test Case: 45 miles in 0 hours 30 mins (0.5 hours) -> 90 MPH
        test.setNums(45, 0, 30);
        test.calcMPH();

        actualMPH = (double) getPrivateField(test, "mph");
        assertEquals("MPH for 45mi / 30mins incorrect", 90.0, actualMPH, TOLERANCE);
    }

    // ==========================================
    // QUADRATIC TESTS
    // ==========================================
    @Test
    public void testQuadratic() {
        Quadratic test = new Quadratic();

        // Test Case: x^2 + 5x + 6 = 0
        // Factors: (x+2)(x+3) -> Roots: -2, -3
        test.setEquation(1, 5, 6);
        test.calcRoots();

        double r1 = (double) getPrivateField(test, "rootOne");
        double r2 = (double) getPrivateField(test, "rootTwo");

        // We check if the expected roots exist.
        // Note: We don't know which variable holds which root (-2 or -3),
        // so we check that the sum is -5 and product is 6 (Vieta's formulas),
        // or simply check specific assignments if the formula is standard.
        // Assuming Standard Quadratic Formula: r1 = (-b + sqrt)/2a, r2 = (-b - sqrt)/2a

        double expectedR1 = (-5 + Math.sqrt(25 - 24)) / 2; // -2
        double expectedR2 = (-5 - Math.sqrt(25 - 24)) / 2; // -3

        assertEquals("Quadratic Root One incorrect", expectedR1, r1, TOLERANCE);
        assertEquals("Quadratic Root Two incorrect", expectedR2, r2, TOLERANCE);
    }
}