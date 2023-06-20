package View.geniusLabels;

import Enums.Cor;

public class AmareloLabel extends GeniusLabels {

    public AmareloLabel() {
        super("amarelo 1.png", "amarelo branco.png", "Re.wav", Cor.amarelo, 'a');
    }

    @Override
    public void setImagemParaRosa() {
        this.setImagem("amarelo rosa.png");
    }

    @Override
    public void setImagemPadrao() {
        this.setImagem("amarelo 1.png");
    }

    @Override
    public String toString() {
        return "AmareloLabel";
    }

}
