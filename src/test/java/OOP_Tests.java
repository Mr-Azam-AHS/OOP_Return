import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class OOP_Tests {

    // TOLERANCE for double comparisons (handles tiny floating point precision errors)
    private static final double TOLERANCE = 0.001;

    // --- Helper Method to Access Private Fields ---
    // Note: This allows us to grade the internal variables even if 
    // the student made them private (which is good practice!)
    private Object getPrivateField(Object instance, String fieldName) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true); // Unlock private field
            return field.get(instance);
        } catch (Exception e) {
            // If this fails, it usually means the student misspelled the variable name
            throw new RuntimeException("Could not find the variable named '" + fieldName + "'. Check your spelling!", e);
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

        // JUnit 5 Syntax: (Expected, Actual, Delta, Message)
        assertEquals(12.0, actualPerimeter, TOLERANCE, "Triangle Perimeter (3,4,5) incorrect");
        assertEquals(6.0, actualArea, TOLERANCE, "Triangle Area (3,4,5) incorrect");
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

        assertEquals(5.0, actualDist, TOLERANCE, "Distance between (0,0) and (3,4) incorrect");

        // Test Case: (1,1) to (2,2) -> Distance sqrt(2) approx 1.414
        test.setCoordinates(1, 1, 2, 2);
        test.calcDistance();
        actualDist = (double) getPrivateField(test, "distance");

        assertEquals(1.414, actualDist, TOLERANCE, "Distance between (1,1) and (2,2) incorrect");
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
        assertEquals(50.0, actualMPH, TOLERANCE, "MPH for 100mi / 2hr incorrect");

        // Test Case: 45 miles in 0 hours 30 mins (0.5 hours) -> 90 MPH
        test.setNums(45, 0, 30);
        test.calcMPH();

        actualMPH = (double) getPrivateField(test, "mph");
        assertEquals(90.0, actualMPH, TOLERANCE, "MPH for 45mi / 30mins incorrect");
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

        double expectedR1 = (-5 + Math.sqrt(25 - 24)) / 2; // -2
        double expectedR2 = (-5 - Math.sqrt(25 - 24)) / 2; // -3

        assertEquals(expectedR1, r1, TOLERANCE, "Quadratic Root One incorrect");
        assertEquals(expectedR2, r2, TOLERANCE, "Quadratic Root Two incorrect");
    }
}