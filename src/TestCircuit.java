/**
 * The TestCircuit class is a test program that demonstrates the functionality
 * of various circuit-related classes, including Resistor, Potentiometer,
 * SerialCircuit, ParallelCircuit, and more.
 */
public class TestCircuit {
    /**
     * The main method is the entry point of the program. It calls various test
     * methods to showcase the functionality of different circuit scenarios.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        SerialCircuit s = new SerialCircuit(new SerialCircuit(1,1));
        Resistor r = new Resistor(100);
        System.out.println("r = " + r +"\n");
        System.out.println("complicated1(new Resistor(200)) = " + complicated1(new Resistor(400)) + "\n");
        System.out.println("potentio1() = \n" + potentio1() + "\n");
        System.out.println("ellipse1() = " + ellipse1() + "\n");
        System.out.println("ellipse2() = " + ellipse2() + "\n");
        System.out.println("complicated2() = " + complicated2() + "\n");
        System.out.println("complicated3() = " + complicated3() + "\n");
        System.out.println("complicated4() = " + complicated4() + "\n");
        System.out.println("complicated5() = " + complicated5() + "\n");
        testExceptions();

    }

    /**
     * Creates a complicated parallel circuit with a given Resistor and returns
     * the resulting ParallelCircuit.
     *
     * @param r2 The Resistor object used in the circuit.
     * @return The resulting ParallelCircuit.
     */
    public static ParallelCircuit complicated1(Resistor r2) {
        return (new ParallelCircuit(new SerialCircuit(new ParallelCircuit(100, 300), 200), new SerialCircuit(r2, 500), 600));
    }

    /**
     * Creates and returns a specific ParallelCircuit configuration.
     *
     * @return The configured ParallelCircuit object.
     */
    public static ParallelCircuit complicated2() {
        return new ParallelCircuit(new SerialCircuit(100, 200), new SerialCircuit(300, 400), new ParallelCircuit(510, 520), new SerialCircuit(650, 650));
    }

    /**
     * Creates a SerialCircuit with an ellipse configuration.
     *
     * @return The created SerialCircuit.
     */
    public static SerialCircuit complicated3() {
        return new SerialCircuit(ellipse2(), complicated2());
    }

    /**
     * Creates a SerialCircuit with a complicated configuration.
     *
     * @return The created SerialCircuit.
     */
    public static SerialCircuit complicated4() {
        return new SerialCircuit(complicated3(), ellipse2());
    }

    /**
     * Creates a SerialCircuit with a more complicated configuration.
     *
     * @return The created SerialCircuit.
     */
    public static SerialCircuit complicated5() {
        return new SerialCircuit(new ParallelCircuit(ellipse2(), ellipse2(), ellipse2()), complicated2(), new ParallelCircuit(ellipse2(), ellipse2(), ellipse2()));
    }

    /**
     * Generates and returns a formatted string presenting the resistance values
     * of a Potentiometer in a ParallelCircuit for different Potentiometer settings.
     *
     * @return The formatted string representing resistance values.
     */
    public static String potentio1() {
        Potentiometer p1 = new Potentiometer(0);
        StringBuilder r = new StringBuilder("""
                ------------------------
                | Resistance | Result  |
                """);
        for (int i = 0; i <= 5000; i += 200) {
            p1.set(i);
            ParallelCircuit c = complicated1(p1);
            r.append(String.format("|     %4d Ω | %5.1f Ω |%n", i, c.getResistance()));

        }
        return r + "------------------------";
    }

    /**
     * Creates and returns a ParallelCircuit with a specific resistor and
     * serial circuit configuration.
     *
     * @return The created ParallelCircuit.
     */
    public static ParallelCircuit ellipse1() {
        return new ParallelCircuit(new Resistor(100), new Resistor(200), new SerialCircuit(new Resistor(310), new Resistor(320)));
    }

    /**
     * Creates and returns another ParallelCircuit with a specific resistor and
     * serial circuit configuration.
     *
     * @return The created ParallelCircuit.
     */
    public static ParallelCircuit ellipse2() {
        return new ParallelCircuit(100, 200, new SerialCircuit(310, 320));
    }

    /**
     * Tests various exceptions by attempting to create circuits with invalid
     * resistor values and handles the exceptions accordingly.
     */
    public static void testExceptions() {
        try {
            Resistor r1 = new Resistor(-12);
        } catch (IllegalArgumentException e) {
            System.err.println("r1 is negative");
        }
        try {
            Potentiometer p1 = new Potentiometer(12);
            p1.set(-12);
        } catch (IllegalArgumentException e) {
            System.err.println("p1 is negative");
        }
        try {
            SerialCircuit s1 = new SerialCircuit(-12, -12);
        } catch (IllegalArgumentException e) {
            System.err.println("serial1 is negative");
        }
        try {
            ParallelCircuit p1 = new ParallelCircuit(-12, -12);
        } catch (IllegalArgumentException e) {
            System.err.println("parallel1 is negative");
        }

    }
}
