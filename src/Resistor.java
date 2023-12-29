public class Resistor extends Circuit {
    private double value;

    public Resistor() {
        value = 0;
    }

    public Resistor(double value) {
        this.value = value;
    }

    protected void set(double resistance) {
        value = resistance;
    }

    /**
     * @return
     */
    @Override
    public double getResistance() {
        return value;
    }

    /**
     * @return
     */
    @Override
    String toSimpleString() {
        return "";
    }

    /**
     * @return
     */
    @Override
    String toCountString() {
        return "";
    }

    /**
     * @return
     */
    @Override
    int getCount() {
        return 1;
    }
}
