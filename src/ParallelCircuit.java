/**
 * Represents a parallel electrical circuit composed of multiple sub-circuits.
 * Extends the abstract class Circuit.
 */
public class ParallelCircuit extends Circuit {

    /**
     * Array of sub-circuits in the parallel circuit.
     */
    private final Circuit[] c;

    /**
     * Constructs a ParallelCircuit with the given sub-circuits.
     * Converts Number objects to Resistors if necessary.
     *
     * @param circuits Array of Circuit objects or Numbers representing resistances.
     * @throws IllegalArgumentException if the number of sub-circuits is less than 2.
     */
    public ParallelCircuit(Object... circuits) {
        c = new Circuit[circuits.length];
        for (int i = 0; i < circuits.length; i++) {
            c[i] = circuits[i] instanceof Number ? new Resistor(((Number) circuits[i]).doubleValue()) : (Circuit) circuits[i];
        }
        if (c.length < 2) {
            throw new IllegalArgumentException("Not enough params");
        }
    }

    /**
     * Calculates and returns the equivalent resistance of the parallel circuit.
     *
     * @return Equivalent resistance of the parallel circuit.
     */
    @Override
    double getResistance() {
        double r = 0;
        for (Circuit circuit : c) {
            r += 1 / circuit.getResistance();
        }
        return 1 / r;
    }

    /**
     * Generates a simple string representation of the parallel circuit,
     * including its sub-circuits.
     *
     * @return Simple string representation of the parallel circuit.
     */
    @Override
    String toSimpleString() {
        StringBuilder r = new StringBuilder("[");
        for (int i = 0; i < c.length; i++) {
            r.append((c[i] instanceof Resistor) ? c[i].toString() : c[i].toSimpleString());
            if (i != c.length - 1) {
                r.append(" | ");
            }
        }
        return r + "]";
    }

    /**
     * Generates a string indicating the number of resistances in the parallel circuit.
     *
     * @return String indicating the number of resistances.
     */
    @Override
    String toCountString() {
        return String.format(" (Number of Resistances: %d)", getCount());
    }

    /**
     * Calculates and returns the total number of resistances in the parallel circuit.
     *
     * @return Total number of resistances in the parallel circuit.
     */
    @Override
    int getCount() {
        int r = 0;
        for (Circuit circuit : c) {
            r += circuit.getCount();
        }
        return r;
    }
}
