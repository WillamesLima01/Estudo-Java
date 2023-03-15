package app;

import entidades.TrianguloB;

public class AppBOO {
    public static void main(String[] args) {
        TrianguloB t1 = new TrianguloB();
        TrianguloB t2 = new TrianguloB();

        t1.a = 3.0;
        t1.b = 4.0;
        t1.c = 5.0;

        t2.a = 7.5;
        t2.b = 4.5;
        t2.c = 4.02;

        double pt1 = (t1.a + t1.b + t1.c) / 2;
        double pt2 = (t2.a + t2.b + t2.c) / 2;

        double areax = Math.sqrt(pt1 * (pt1 - t1.a) * (pt1 - t1.b) * (pt1 - t1.c));
        double areay = Math.sqrt(pt2 * (pt2 - t2.a) * (pt2 - t2.b) * (pt2 - t2.c));

        System.out.println("Área pt1: " + areax);
        System.out.println("Área y: " + areay);

        if (areax > areay) {
            System.out.println("A área de x é maior que y");
        } else {
            System.out.println("A área de y é maior que x");
        }


    }
}
