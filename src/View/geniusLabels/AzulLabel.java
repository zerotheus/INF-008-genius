package View.geniusLabels;

import Enums.Cor;

public class AzulLabel extends GeniusLabels {

    public AzulLabel() {
        super("azul.png", "azul branco.png", "La.wav", Cor.azul);
    }

    @Override
    public void setImagemParaRosa() {
        this.setImagem("azul rosa.png");
    }

    @Override
    public void setImagemPadrao() {
      this.setImagem("azul.png");
    }

}
