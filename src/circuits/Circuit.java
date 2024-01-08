package circuits;

/**
 * The abstract class representing an electrical circuit.
 */
public abstract class Circuit {

    /**
     * Gets the resistance of the circuit.
     *
     * @return The resistance of the circuit.
     */
    abstract double getResistance();

    /**
     * Returns a simplified string representation of the circuit.
     *
     * @return A simplified string representation of the circuit.
     */
    abstract String toSimpleString();

    /**
     * Returns a detailed string representation of the circuit, including counts or additional information.
     *
     * @return A detailed string representation of the circuit.
     */
    abstract String toCountString();

    /**
     * Gets the count of circuit elements, if applicable.
     *
     * @return The count of circuit elements.
     */
    abstract int getCount();

    /**
     * Returns a string representation of the circuit, combining simple, resistance, and count information.
     *
     * @return A string representation of the circuit.
     */
    public String toString() {
        String s = toSimpleString();
        s += s.isBlank() ? "" : " = ";
        return s + getResistance() + " Ω" + toCountString();

    }
}
