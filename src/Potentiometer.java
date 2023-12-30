/**
 * The {@code Potentiometer} class represents a variable resistor (potentiometer)
 * that extends the functionality of the {@code Resistor} class.
 * It allows setting a variable resistance value.
 *
 * @author Your Name
 * @version 1.0
 * @see Resistor
 */
public class Potentiometer extends Resistor {

    /**
     * The resistance value of the potentiometer.
     */
    private double value;

    /**
     * Constructs a new {@code Potentiometer} instance with a default resistance value of 0 ohms.
     * Calls the constructor of the superclass {@code Resistor}.
     */
    public Potentiometer() {
        super();
    }

    /**
     * Constructs a new {@code Potentiometer} instance with the specified resistance value.
     * Calls the constructor of the superclass {@code Resistor}.
     *
     * @param value The resistance value of the potentiometer.
     */
    public Potentiometer(double value) {
        super(value);
    }

    /**
     * Sets the resistance value of the potentiometer.
     * Calls the {@code set} method of the superclass {@code Resistor}.
     *
     * @param value The new resistance value to be set.
     */
    public void set(double value) {
        super.set(value);
    }
}
