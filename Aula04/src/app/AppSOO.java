package app;

public class AppSOO {
    public static void main(String[] args) {

        double xa = 3.0, xb = 4.0, xc = 5.0;

        double ya = 7.5, yb = 4.5, yc = 4.02;


        double px = (xa + xb + xc) / 2;
        double py = (ya + yb + yc) / 2;

        double areax = Math.sqrt(px * (px - xa) * (px - xb) * (px - xc));
        double areay = Math.sqrt(py * (py - ya) * (py - yb) * (py - yc));

        System.out.println("Área x: " + areax);
        System.out.println("Área y: " + areay);

        if (areax > areay) {
            System.out.println("A área de x é maior que y");
        } else {
            System.out.println("A área de y é maior que x");
        }
    }
}
