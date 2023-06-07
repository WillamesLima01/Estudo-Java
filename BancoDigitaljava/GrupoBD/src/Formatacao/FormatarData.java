package Formatacao;

public class FormatarData {

    private String dataTx;

    public String getDataTx() {

        return dataTx;
    }

    public void setDataTx(String dataTx) {
        String dataString;
        dataString = dataTx.substring(0,2) + "/" + dataTx.substring(2,4) + "/" + dataTx.substring(4);
        this.dataTx = dataString;
    }

}
