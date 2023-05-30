package View;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicialFrame extends JFrame implements MouseListener {

    private static String basePath;
    private static String imagesBasePath;

    public TelaInicialFrame() {
        basePath = new File("").getAbsolutePath() + "\\";
        imagesBasePath = basePath + new File("src\\imagens").getPath() + "\\";
        JLabel lblbutao = new JLabel("butao");
        lblbutao.setIcon(
                new ImageIcon(TelaInicialFrame.imagesBasePath + "botão iniciar.png"));
        lblbutao.setBounds(587, 573, 276, 117);
        this.getContentPane().add(lblbutao);

        JLabel lbltelaFundo = new JLabel();
        System.out.println(TelaInicialFrame.imagesBasePath + "tela.png");
        lbltelaFundo.setIcon(new ImageIcon(TelaInicialFrame.imagesBasePath + "tela.png"));
        lbltelaFundo.setBounds(0, 0, 1451, 884);
        this.getContentPane().add(lbltelaFundo);

        this.add(lblbutao);
        this.add(lbltelaFundo);
        FrontEndManager frontEnd = new FrontEndManager();
        frontEnd.setFrontEnd(this);
        lblbutao.addMouseListener(frontEnd);

    }

    public static JFrame getTelaIncial(JFrame frame) {

        frame = new TelaInicialFrame();

        return frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}
