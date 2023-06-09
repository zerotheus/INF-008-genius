package View.geniusLabels;

import Enums.Cor;

public class VerdeLabel extends GeniusLabels {

    public VerdeLabel() {
        super("verde 1.png", "verde branco.png", "Mi.wav", Cor.verde, 'd');
    }

    @Override
    public void setImagemParaRosa() {
        this.setImagem("verde rosa.png");
    }

    @Override
    public void setImagemPadrao() {
        this.setImagem("verde 1.png");
    }

    @Override
    public String toString() {
        return "VerdeLabel";
    }
 /* classe que cria o botão verde e coloca as imagens*/
}
