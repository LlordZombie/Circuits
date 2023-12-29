public class TestCircuit {
    public static void main(String[] args) {
        Circuit r1 = new Resistor(100);
        System.out.println("r1 = " + r1.getResistance() + " Ω");
        System.out.println(r1);
        Circuit r2 = new Resistor(200);
        System.out.println(new SerialCircuit(r1, r2).getResistance());
        System.out.println(new SerialCircuit(new ParallelCircuit(r1, r2), r2));
        System.out.println(new ParallelCircuit(r1, r2).getResistance());
        complicated1();
    }

    public static void complicated1() {
        Resistor r = new Potentiometer(0);
        for (int i = 0; i <= 5000; i += 200) {
            r.set(i);
            System.out.println(new ParallelCircuit(new SerialCircuit(new ParallelCircuit(new Resistor(100), new Resistor(300)), new Resistor(200)), new SerialCircuit(r, new Resistor(500)), new Resistor(600)));
        }
    }
}
