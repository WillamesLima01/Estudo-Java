package Formatacao;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FormatarData {

    private String dataTx;
    private String dataString;

    public String getDataTx() {

        return dataTx;
    }

    public void setDataTx(String dataTx) {

        dataString = dataTx.substring(0,2) + "/" + dataTx.substring(2,4) + "/" + dataTx.substring(4);
        this.dataTx = dataString;
    }

    public static boolean isDataValida(String data) {
        try {
            LocalDate.parse(data);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
