package circuits;

/**
 * The circuits.Resistor class represents a resistor component in an electrical circuit.
 * It extends the circuits.Circuit class and provides functionality specific to resistors.
 */
public class Resistor extends Circuit {
    /**
     * The resistance value of the resistor.
     */
    private double value;

    /**
     * Constructs a resistor with a default resistance value of 0 ohms.
     */
    public Resistor() {
        value = 0;
    }

    /**
     * Constructs a resistor with the specified resistance value.
     *
     * @param value The resistance value of the resistor. Must be non-negative.
     * @throws IllegalArgumentException If the specified resistance is negative.
     */
    public Resistor(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Resistance is negative");
        }
        this.value = value;
    }

    /**
     * Sets the value value of the resistor.
     *aaaa
     * @param value The new value value. Must be non-negative.
     * @throws IllegalArgumentException If the specified value is negative.
     */
    protected void set(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Resistance is negative");
        }
        this.value = value;
    }

    /**
     * Gets the resistance value of the resistor.
     *
     * @return The resistance value of the resistor.
     */
    @Override
    public double getResistance() {
        return value;
    }

    /**
     * Returns a simple string representation of the resistor.
     *
     * @return A simple string representation.
     */
    @Override
    String toSimpleString() {
        return "";
    }

    /**
     * Returns a detailed string representation of the resistor.
     *
     * @return A detailed string representation.
     */
    @Override
    String toCountString() {
        return "";
    }

    /**
     * Returns the count of resistors. For a single resistor, it always returns 1.
     *
     * @return The count of resistors (always 1 for a single resistor).
     */
    @Override
    int getCount() {
        return 1;
    }
}
