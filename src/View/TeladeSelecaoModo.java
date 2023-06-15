package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Negocio.Genius;

public class TeladeSelecaoModo extends MyJPanel {

    private JLabel lblTeladeFundo;

    public TeladeSelecaoModo(JTabbedPane tabbedPane) {
        super();
        lblTeladeFundo = new JLabeldateladeFundo();

        MyJLabelwithSound lblCampeonato = new MyJLabelwithSound();
        lblCampeonato.setEnabled(true);
        lblCampeonato.setIcon(
                new ImageIcon(this.getImagesPath() + "VARIOS JOGADORES.png"));
        lblCampeonato.setBounds(263, 583, 264, 95);
        lblCampeonato.setVisible(true);
        this.add(lblCampeonato);

        MyJLabelwithSound lblindividual = new MyJLabelwithSound();
        lblindividual.setEnabled(true);
        lblindividual.setIcon(
                new ImageIcon(this.getImagesPath() + "SOLO BOTAO.png"));
        lblindividual.setBounds(578, 583, 264, 95);
        lblindividual.setVisible(true);

        MyJLabelwithSound lblCarregar = new MyJLabelwithSound();
        lblCarregar.setIcon(new ImageIcon(this.getImagesPath() + "Carregar.png"));
        lblCarregar.setBounds(894, 583, 264, 95);

        MyJLabelwithSound lblExtra = new MyJLabelwithSound();
        lblExtra.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
        lblExtra.setForeground(Color.RED);
        lblExtra.setText("EXTRAS");
        lblExtra.setBounds(629, 783, 264, 95);

        this.add(lblCarregar);
        this.add(lblindividual);
        this.add(lblExtra);
        this.add(lblTeladeFundo);

        lblindividual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblindividual) {
                    return;
                }
                try {
                    lblindividual.startSound();
                } catch (Exception e1) {
                    System.out.println(e1.toString());
                }

                JPanel novoJPanel = new TelaCadastro(tabbedPane, 1);
                tabbedPane.insertTab("Individual", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        lblCampeonato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblCampeonato) {
                    return;
                }
                try {
                    lblCampeonato.startSound();
                } catch (Exception e1) {
                    System.out.println(e1.toString());
                }
                JPanel novoJPanel = new TelaCampeonatoSelecao(tabbedPane);
                tabbedPane.insertTab("CampeonatoSelecao", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);
            }

        });

        lblCarregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    lblCarregar.startSound();
                } catch (Exception e1) {
                    System.out.println(e.toString());
                }
                Genius jogoCarregado = null;
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        FileInputStream fis = new java.io.FileInputStream(file);
                        ObjectInputStream is = new ObjectInputStream(fis);
                        jogoCarregado = (Genius) is.readObject();
                    } catch (IOException | ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    // This is where a real application would open the file.
                }
                if (jogoCarregado == null) {
                    return;
                }
                JPanel telaPlacar = new TelaPlacar(tabbedPane, jogoCarregado);
                tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

        lblExtra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblExtra) {
                    return;
                }
                try {
                    lblExtra.startSound();
                } catch (Exception e1) {
                    System.out.println(e1.toString());
                }

                /*
                 * JPanel novoJPanel = new TelaCadastro(tabbedPane, 1);
                 * tabbedPane.insertTab("Individual", null, novoJPanel, TOOL_TIP_TEXT_KEY, 1);
                 * tabbedPane.removeTabAt(0);
                 */

            }
        });

    }

}
