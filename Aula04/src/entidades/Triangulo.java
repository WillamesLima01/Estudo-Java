package entidades;

public class Triangulo {

    private double a, b, c;

    public Triangulo(double a, double b, double c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double calcularP() {
        double p = (this.a + this.b + this.c) / 2;
        return p;
    }

    public double calcularArea() {
        double pc = calcularP();
        double area = Math.sqrt(pc * (pc - this.a) * (pc - this.b) * (pc - this.c));
        return area;
    }

}
