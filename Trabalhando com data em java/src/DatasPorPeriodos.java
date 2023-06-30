import java.time.LocalDate;
import java.time.Period;

public class DatasPorPeriodos {

    public static void main(String[] args) {
        String datacadastro = "2021-11-17";
        String dataAtual = "2023-04-22";
        LocalDate dataAntiga = LocalDate.parse(datacadastro);
        LocalDate dataAtual1 = LocalDate.parse(dataAtual);

        System.out.println("Data antiga é maior que data atual : " + dataAntiga.isAfter(dataAtual1));
        System.out.println("Data antiga é anterior que data atual : " + dataAntiga.isBefore(dataAtual1));
        System.out.println("Data antiga é igual a data atual : " + dataAntiga.isEqual(dataAtual1));

        Period periodo = Period.between(dataAntiga, dataAtual1);

        System.out.println("Dias : " + periodo.getDays());
        System.out.println("Total de meses : " + periodo.toTotalMonths());

    }

}
