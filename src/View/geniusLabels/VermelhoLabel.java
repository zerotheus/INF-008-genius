package View.geniusLabels;

import Enums.Cor;

public class VermelhoLabel extends GeniusLabels {

    public VermelhoLabel() {
        super("vermelho 1.png", "vermelho branco.png", "Si.wav", Cor.vermelho, 's');
    }

    @Override
    public void setImagemParaRosa() {
        this.setImagem("vermelho rosa.png");
    }

    @Override
    public void setImagemPadrao() {
        this.setImagem("vermelho 1.png");
    }

    @Override
    public String toString() {
        return "VermelhoLabel";
    }

}
