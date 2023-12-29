public class SerialCircuit extends Circuit {

    private final Circuit[] c;

    public SerialCircuit(Object... circuits) {
        c = new Circuit[circuits.length];
        for (int i = 0; i < circuits.length; i++) {
            c[i] = circuits[i] instanceof Number ? new Resistor(((Number) circuits[i]).doubleValue()) : (Circuit) circuits[i];
        }
        if (c.length < 2) {
            throw new IllegalArgumentException("Not enough params");
        }
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
        for (int i = 0; i < c.length; i++) {
            r.append((c[i] instanceof Resistor) ? c[i].toString() : c[i].toSimpleString());
            if (i != c.length - 1) {
                r.append(" + ");
            }
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
