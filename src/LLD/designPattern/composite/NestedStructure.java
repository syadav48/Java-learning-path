package LLD.designPattern.composite;

public class NestedStructure {
    public static void main(String[] args) {
        Region wb = new Region("West Bengal");
        Region hooghy = new Region("Hooghly");
        Region kolkata = new Region("Kolkata");
        Village raghunathpur = new Village("Raghunath Pur");
        Ward mankundu = new Ward("Mankundu");
        hooghy.add(raghunathpur);
        hooghy.add(mankundu);
        wb.add(hooghy);
        wb.add(kolkata);
        // wb
        wb.showHierachy();



    }
}
