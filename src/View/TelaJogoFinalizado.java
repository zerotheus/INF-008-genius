package View;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.plaf.FileChooserUI;
import javax.swing.ImageIcon;
import Enums.Cor;
import Negocio.Genius;
import View.geniusLabels.AmareloLabel;
import View.geniusLabels.AzulLabel;
import View.geniusLabels.GeniusLabels;
import View.geniusLabels.VerdeLabel;
import View.geniusLabels.VermelhoLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TelaJogoFinalizado extends MyJPanel{

	private Genius jogo;
	private JTabbedPane tabbedPane;


	public TelaJogoFinalizado(JTabbedPane tabbedPane, Genius jogo) {
		super();
		this.tabbedPane = tabbedPane;
		this.setLayout(null);
		this.jogo = jogo;

        JLabel lblPontos = new JLabel("" + jogo.getJogadorAtual().getPontos());
		lblPontos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		lblPontos.setForeground(new Color(255, 255, 255));
		lblPontos.setBounds(175, 589, 67, 57);
		JLabel lblNomeJogador = new JLabel(jogo.getJogadorAtual().getApelido());
		lblNomeJogador.setForeground(new Color(255, 255, 255));
		lblNomeJogador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblNomeJogador.setBounds(95, 221, 241, 39);
        lblNomeJogador.setText(jogo.getJogadorAtual().getApelido());
		lblPontos.setText("" + jogo.getJogadorAtual().getPontos());
        this.add(lblPontos);
        this.add(lblNomeJogador);

        MyJLabelwithSound btnSalvar = new MyJLabelwithSound();
		btnSalvar.setBounds(1223, 405, 173, 57);
		btnSalvar.setVisible(true);
		this.add(btnSalvar);

        JLabel lblFundoJogo = new JLabel();
		lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "JogoFinalizado.png"));
		lblFundoJogo.setBounds(0, 0, 1444, 881);
		this.add(lblFundoJogo);


        btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnSalvar.startSound();
				} catch (Exception e1) {
					System.out.println(e.toString());
				}

				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(lblFundoJogo);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						FileOutputStream fileStream = new FileOutputStream(file);
						ObjectOutputStream os = new ObjectOutputStream(fileStream);
						os.writeObject(jogo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// This is where a real application would open the file.
				}
				JPanel telaPlacar = new TelaPlacar(tabbedPane, jogo);
				tabbedPane.insertTab("Genius", null, telaPlacar, TOOL_TIP_TEXT_KEY, 1);
				tabbedPane.removeTabAt(0);

			}
		});
    }
}
