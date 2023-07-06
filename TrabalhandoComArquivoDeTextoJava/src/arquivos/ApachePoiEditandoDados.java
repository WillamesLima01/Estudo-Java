package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ApachePoiEditandoDados {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\arquivo_exel.xls");

        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*entrada do arquivo xls Excel*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*pegando a planilha*/

        Iterator<Row> linhaInterator = planilha.iterator();

        while (linhaInterator.hasNext()) {
            Row linha = linhaInterator.next();

            int numerocelula = linha.getPhysicalNumberOfCells();

            String valorCelular = linha.getCell(0).getStringCellValue();

            linha.getCell(0).setCellValue(valorCelular + " * Valor gravado na aula");
        }

        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha atualizada");

    }
}
