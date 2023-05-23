package Formatacao;

public class FormatarData {
	
	private String dataTx;
	private String dataString;

	public String getDataTx() {
		return dataTx;
	}

	public void setDataTx(String dataTx) {
		
		dataString = dataTx.substring(0,2) + "/" + dataTx.substring(2,4) + "/" + dataTx.substring(4);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//dataFormatada=dateFormat.format(dataString);
		this.dataTx = dataString;
	}
}
