package propriedades;

import entidade.Propriedade;

import java.awt.*;

public class Apartamentos extends Propriedade {

    private String descricaoPropriedade;
    private Image fotos;
    private String comodidades;

    public Apartamentos(String endereco, int nQuartos, Double preco, String descricaoPropriedade, Image fotos, String comodidades) {
        super(endereco, nQuartos, preco);
        this.descricaoPropriedade = descricaoPropriedade;
        this.fotos = fotos;
        this.comodidades = comodidades;
    }

    public String getDescricaoPropriedade() {
        return descricaoPropriedade;
    }

    public void setDescricaoPropriedade(String descricaoPropriedade) {
        this.descricaoPropriedade = descricaoPropriedade;
    }

    public Image getFotos() {
        return fotos;
    }

    public void setFotos(Image fotos) {
        this.fotos = fotos;
    }

    public String getComodidades() {
        return comodidades;
    }

    public void setComodidades(String comodidades) {
        this.comodidades = comodidades;
    }
}
