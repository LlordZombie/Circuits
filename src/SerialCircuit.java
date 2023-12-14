public class SerialCircuit extends Circuit {

    private final Circuit[] c;

    public SerialCircuit(Circuit... c) {
        this.c = c;
    }

    /**
     * @return
     */
    @Override
    double getResistance() {
        double r = 0;
        for (Circuit circuit : c) {
            r += circuit.getResistance();
        }
        return r;
    }

    /**
     * @return
     */
    @Override
    String toSimpleString() {
        StringBuilder r = new StringBuilder("(");
        for (Circuit circuit : c) {
            r.append((circuit instanceof Resistor) ? circuit.toString() : circuit.toSimpleString());
            r.append(" + ");
        }
        return r + ")";
    }

    /**
     * @return
     */
    @Override
    String toCountString() {
        return String.format(" (Anzahl der Widerstände: %d)", getCount());
    }

    /**
     * @return
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
