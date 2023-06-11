package View.geniusLabels;

import Enums.Cor;

public class VerdeLabel extends GeniusLabels {

    public VerdeLabel() {
        super("verde 1.png", "verde branco.png", "Mi.wav", Cor.verde);
    }

    @Override
    public void setImagemParaRosa() {
        this.setImagem("verde rosa.png");
    }

    @Override
    public void setImagemPadrao() {
        this.setImagem("verde 1.png");
    }

}
