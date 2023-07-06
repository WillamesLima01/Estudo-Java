package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoi2 {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\arquivo_exel.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo excel para ler*/

        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*Pega a primeira planilha do nosso arquivo Excel*/

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) { /*enquanto tiver linha no arquivo excel*/
            Row linha = linhaIterator.next(); /*Dados da pessoa na linha*/
            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while(celulas.hasNext()) {/*Percorrer as celulas*/
                Cell cell = celulas.next();

                switch (cell.getColumnIndex()){
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cell.getColumnIndex());
                }

            }/*Fim das celulas da linha*/

            pessoas.add(pessoa);

        }

        entrada.close();

        for (Pessoa pessoa : pessoas) {

            System.out.println(pessoa);

        }
    }
}
