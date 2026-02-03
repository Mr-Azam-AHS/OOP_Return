import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OOP_Tests {

    // TOLERANCE for double comparisons
    private static final double TOLERANCE = 0.001;

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

        // Standard Getter usage
        assertEquals(12.0, test.getPerimeter(), TOLERANCE, "Triangle Perimeter (3,4,5) incorrect");
        assertEquals(6.0, test.getArea(), TOLERANCE, "Triangle Area (3,4,5) incorrect");
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

        assertEquals(5.0, test.getDistance(), TOLERANCE, "Distance between (0,0) and (3,4) incorrect");

        // Test Case: (1,1) to (2,2) -> Distance sqrt(2) approx 1.414
        test.setCoordinates(1, 1, 2, 2);
        test.calcDistance();

        assertEquals(1.414, test.getDistance(), TOLERANCE, "Distance between (1,1) and (2,2) incorrect");
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

        assertEquals(50.0, test.getMPH(), TOLERANCE, "MPH for 100mi / 2hr incorrect");

        // Test Case: 45 miles in 0 hours 30 mins (0.5 hours) -> 90 MPH
        test.setNums(45, 0, 30);
        test.calcMPH();

        assertEquals(90.0, test.getMPH(), TOLERANCE, "MPH for 45mi / 30mins incorrect");
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

        double expectedR1 = (-5 + Math.sqrt(25 - 24)) / 2; // -2
        double expectedR2 = (-5 - Math.sqrt(25 - 24)) / 2; // -3

        assertEquals(expectedR1, test.getRootOne(), TOLERANCE, "Quadratic Root One incorrect");
        assertEquals(expectedR2, test.getRootTwo(), TOLERANCE, "Quadratic Root Two incorrect");
    }
}