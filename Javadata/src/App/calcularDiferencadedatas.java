package App;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class calcularDiferencadedatas {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        date dt1 = sdf.parse(sc.next());
        date dt2 = sdf.parse(sc.next());

        long diff = dt1.getTime() - dt2.getTime();
        long dias = TimeUnit.DAYS.conver
    }
}
