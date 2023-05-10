package entidade;

import java.util.Date;

public class Reserva {

    private String propriedadeReservada;
    private Date entrada;
    private Date saida;
    private Double vlrTotal;
    private String hospede;


    public Reserva(String propriedadeReservada, Date entrada, Date saida, Double vlrTotal, String hospede) {
        this.propriedadeReservada = propriedadeReservada;
        this.entrada = entrada;
        this.saida = saida;
        this.vlrTotal = vlrTotal;
        this.hospede = hospede;
    }

    public String getPropriedadeReservada() {
        return propriedadeReservada;
    }

    public void setPropriedadeReservada(String propriedadeReservada) {
        this.propriedadeReservada = propriedadeReservada;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }
}
