package circuits;

/**
 * Represents a serial circuit composed of multiple circuits connected in series.
 * The total resistance of the serial circuit is the sum of the resistances of its components.
 */
public class SerialCircuit extends Circuit {

    /**
     * Array of circuits connected in series.
     */
    private final Circuit[] c;

    /**
     * Constructs a serial circuit with the specified components.
     *
     * @param circuits The circuits to be connected in series.
     * @throws IllegalArgumentException If less than 2 circuits are provided.
     */
    public SerialCircuit(Object ... circuits) {
        c = new Circuit[circuits.length];
        for (int i = 0; i < circuits.length; i++) {
            c[i] = circuits[i] instanceof Number ? new Resistor(((Number) circuits[i]).doubleValue()) : (Circuit) circuits[i];
        }
        if (getCount() < 2) {
            throw new IllegalArgumentException("Not enough params");
        }
    }

    /**
     * Calculates and returns the total resistance of the serial circuit.
     *
     * @return The total resistance of the serial circuit.
     */
    @Override
    public double getResistance() {
        double r = 0;
        for (Circuit circuit : c) {//for(int i = 0; i<c.length; i++){
            r += circuit.getResistance();//r+= c[i].getResistance()
        }
        return r;
    }

    /**
     * Returns a simple string representation of the serial circuit,
     * showing the components connected in series.
     *
     * @return A simple string representation of the serial circuit.
     */
    @Override
    String toSimpleString() {
        StringBuilder r = new StringBuilder("(");
        for (int i = 0; i < c.length; i++) {
            r.append((c[i] instanceof Resistor) ? c[i].toString() : c[i].toSimpleString());
            if (i != c.length - 1) {
                r.append(" + ");
            }
        }
        return r + ")";
    }

    /**
     * Returns a formatted string indicating the number of resistances in the serial circuit.
     *
     * @return A string indicating the number of resistances in the serial circuit.
     */
    @Override
    String toCountString() {
        return String.format(" (Number of Resistors: %d)", getCount());
    }

    /**
     * Calculates and returns the total number of resistances in the serial circuit.
     *
     * @return The total number of resistances in the serial circuit.
     */
    @Override
    public int getCount() {
        int r = 0;
        for (Circuit circuit : c) {//for(int i = 0; i<c.length; i++){
            r += circuit.getCount();//r+= c[i].getCount()
        }
        return r;
    }
}