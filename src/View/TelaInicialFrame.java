package View;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicialFrame extends JFrame implements MouseListener, FrameFuncional {

    private static String basePath;
    private static String imagesBasePath;
    private static TelaInicialFrame frame;

    public TelaInicialFrame() {
        basePath = new File("").getAbsolutePath() + "\\";
        imagesBasePath = basePath + new File("imagens").getPath() + "\\";
        System.out.println("tela nova");
    }

    public static TelaInicialFrame getTelaIncial(MouseListener mouse) {
        TelaInicialFrame novoFrame = new TelaInicialFrame();

        JLabel lblbutao = new JLabel("");
        lblbutao.setIcon(
                new ImageIcon(imagesBasePath + "botão iniciar.png"));
        lblbutao.setBounds(587, 573, 276, 117);
        novoFrame.getContentPane().add(lblbutao);

        JLabel lbltelaFundo = new JLabel();
        System.out.println(imagesBasePath + "tela.png");
        lbltelaFundo.setIcon(new ImageIcon(imagesBasePath + "tela.png"));
        lbltelaFundo.setBounds(0, 0, 1451, 884);
        novoFrame.getContentPane().add(lbltelaFundo);

        novoFrame.add(lblbutao);
        novoFrame.add(lbltelaFundo);

        FrontEndManager frontEnd = new FrontEndManager();
        frontEnd.setFrontEnd(novoFrame);
        lbltelaFundo.addMouseListener(frontEnd);

        lblbutao.addMouseListener(mouse

        );
        frame = novoFrame;

        return frame;
    }

    public FrameFuncional atualizaFrame(JFrame frame) {
        FrameFuncional atualizaFrame = () -> {
            this.frame = new TelaInicialFrame();
            return this.frame;
        };
        return atualizaFrame;
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

    @Override
    public TelaInicialFrame iniciaFrameFuncional() {
        System.out.println("n entendi nada");
        return new CrianovaTela();
    }

}
