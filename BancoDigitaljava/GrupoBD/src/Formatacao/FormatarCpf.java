package Formatacao;

import javax.swing.*;
import java.text.DecimalFormat;

public class FormatarCpf {

    private String cpfnumero;
    private String cpfformatado;

    public void setCpfnumero(String cpfnumero) {

        this.cpfnumero = cpfnumero;

    }

    public String getCpfformatado() {

        DecimalFormat format = new DecimalFormat("00000000000");
        this.cpfformatado = format.format(Long.parseLong(cpfnumero));
        return this.cpfformatado.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    }

    public boolean verificarCpf(String cpf){

        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se a sequência possui 11 dígitos
        if (cpf.length() != 11) {

            return false;

        }

        return true;

    }

}

