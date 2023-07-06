package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file =
                new File("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\arquivo_exel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("willames");
        pessoa1.setEmail("illaap@hotmail.com");
        pessoa1.setIdade(42);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("José");
        pessoa2.setEmail("jose@hotmail.com");
        pessoa2.setIdade(50);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("tiago");
        pessoa3.setEmail("tiago@hotmail.com");
        pessoa3.setIdade(28);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /*usado para escrever a planilha*/
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas do curso"); /*criar a planilha*/

        int numeroLinha = 0;
        for(Pessoa p : pessoas){
            Row linha = linhasPessoa.createRow(numeroLinha ++); /*criando a linha na planilha*/

            int celula = 0;
            Cell celNome = linha.createCell(celula ++);
            celNome.setCellValue(p.getNome());

            Cell celemail = linha.createCell(celula ++);
            celemail.setCellValue(p.getEmail());

            Cell celidade = linha.createCell(celula ++);
            celidade.setCellValue(p.getIdade());
        }
        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();
        System.out.println("A planilha foi criada!");
    }
}
