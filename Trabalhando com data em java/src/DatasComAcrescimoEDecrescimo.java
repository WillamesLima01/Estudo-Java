import java.time.LocalDate;

public class DatasComAcrescimoEDecrescimo {

    public static void main(String[] args) {

        LocalDate database = LocalDate.parse("2023-10-05");

        System.out.println("Mais 5 dias : " + (database = database.plusDays(5))); /*aumento de 5 dias*/

        System.out.println("Mais 15 dias : " + database.plusDays(15)); /*aumento de 15 dias*/

        System.out.println("Menos 15 dias : " + database.minusDays(15)); /*decrescimo de 15 dias*/

        System.out.println("Mais 7 semanas : " + database.plusWeeks(7)); /*aumento de 7 semanas*/
        System.out.println("Menos 7 semanas : " + (database = database.minusWeeks(7))); /*decrescimo de 7 semanas*/

        System.out.println("Mais 5 meses : " + database.plusMonths(5)); /*aumento de 5 meses*/

    }
}
