package View;

import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class FrontEndManager extends MouseInputAdapter {

    private JFrame frontEnd;

    public JFrame getFrontEnd() {
        return frontEnd;
    }

    public void setFrontEnd(JFrame frontEnd) {
        this.frontEnd = frontEnd;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(e.getID());
        System.out.println("coisas estranhas");
        System.out.println(e.getButton());
    }

}
