public abstract class Circuit {
    abstract double getResistance();

    abstract String toSimpleString();

    abstract String toCountString();

    abstract int getCount();

    public String toString() {
        String s = toSimpleString();
        s += s.isBlank() ? "" : " = ";
        s += getResistance() + " Ω" + toCountString();
        return s;
    }
}