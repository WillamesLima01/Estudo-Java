package arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTXT  {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaArquivo =
                new FileInputStream("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\Arquivo.txt");

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        while(lerArquivo.hasNext()){

            String linha = lerArquivo.nextLine();

            System.out.println(linha);
        }
    }

}
