import javax.swing.*;
import java.util.Scanner;

public class TestadoraScanner {
    public static void main(String[] args) {
        //Instanciando um objeto do tipo Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu nome abaixo: ");
        String nome = sc.next();
        System.out.println("Seu nome é: " + nome);
        System.out.println("Digite sua idade a baixo: ");
        int idade = sc.nextInt();
        System.out.println("E sua idade é: " + idade);
    }
}
