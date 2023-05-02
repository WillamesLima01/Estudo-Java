package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = sdf.parse(sc.next());

        System.out.println("Data digitada : " + sdf.format(dt));

        sc.close();

    }
}
