package View;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

//Faço questao de deixar explicita a documentacao desta classe
/*https://docs.oracle.com/javase/8/docs/api/javax/swing/plaf/basic/BasicTabbedPaneUI.html*/
//recomendo leitura pois ela nao explica oq nenhum dos dois metodos fazem
//os nomes produzem significado proprio mas nao encontrei o codigo ou explicacao de como é feita
public class MyJTabbedPaneUI extends BasicTabbedPaneUI {

    public MyJTabbedPaneUI() {
        super();
    }

    @Override
    protected int calculateMaxTabHeight(int tabPlacement) {
        return -5;// apos testes cheguei a conclusao que isso é meramente uma referencia de ate
        // onde pode se desenhar a barra de abas entao por isso podem ser retornado
        // valores negativos de referencia de x e de y, 0 nao reproduz o 0 geometrico a
        // area fica visivel ainda
    }

}
