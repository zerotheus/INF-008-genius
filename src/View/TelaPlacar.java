package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Negocio.Genius;
import Negocio.Jogador;

public class TelaPlacar extends MyJPanel {
    private List<JLabel> labelNomes;
    private List<JLabel> labelApelidos;
    private List<JLabel> labelTempoTot;
    private List<JLabel> labelPontosTot;
    private List<JLabel> labelMelhorJgd;

    public TelaPlacar(JTabbedPane tabbedPane, Genius jogo) {
        this.setLayout(null);
        this.desenhaPlacar(jogo);
        JLabel lblDataJogo = new JLabel(jogo.getData().toString());
        lblDataJogo.setForeground(new Color(255, 255, 255));
        lblDataJogo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
        lblDataJogo.setBounds(675, 10, 180, 48);
        this.add(lblDataJogo);

        JLabel lblTituloJogo = new JLabel(jogo.getTitulodoCampeonato());
        lblTituloJogo.setForeground(new Color(255, 255, 255));
        lblTituloJogo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
        lblTituloJogo.setBounds(675, 65, 640, 48);
        this.add(lblTituloJogo);

        MyJLabelwithSound lblVoltar = new MyJLabelwithSound();
        lblVoltar.setIcon(new ImageIcon(this.getImagesPath() + "botaoVoltar.png"));
        lblVoltar.setBounds(1270, 812, 152, 58);
        lblVoltar.setVisible(true);
        this.add(lblVoltar);

        JLabel lblFundoJogo = new JLabel("");
        lblFundoJogo.setIcon(new ImageIcon(this.getImagesPath() + "tela placar.png"));
        lblFundoJogo.setBounds(0, 0, 1444, 881);
        this.add(lblFundoJogo);

        lblVoltar.addMouseListener(new MouseAdapter() { // colocar som ao clicar o botão
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() != lblVoltar) {
                    return;
                }
                try {
                    lblVoltar.startSound();
                } catch (Exception e1) {
                    System.out.println(e.toString());
                }
                lblVoltar.setEnabled(false);
                lblVoltar.setVisible(false);
                JPanel telaInicial = new TelaInicial(tabbedPane);
                tabbedPane.insertTab("Tela Inicial", null, telaInicial, TOOL_TIP_TEXT_KEY, 1);
                tabbedPane.removeTabAt(0);

            }
        });

    }

    public void desenhaPlacar(Genius jogo) {
        int posicao = 70;
        int qtdJogadores = jogo.qtdJogadores();

        /* inicio dos nomes */
        labelNomes = new ArrayList<JLabel>();
        for (int i = 0; i < qtdJogadores; i++) {
            labelNomes.add(new JLabel(jogo.getListaJogadores().get(i).getNome()));
            labelNomes.get(i).setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
            labelNomes.get(i).setForeground(Color.WHITE);
            labelNomes.get(i).setBounds(76, 267 + posicao * i, 315, 38);
            this.add(labelNomes.get(i));
        }
        /* fim dos nomes */

        /* INICIO APELIDO */

        labelApelidos = new ArrayList<JLabel>();
        for (int i = 0; i < qtdJogadores; i++) {
            labelApelidos.add(new JLabel(jogo.getListaJogadores().get(i).getApelido()));
            labelApelidos.get(i).setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
            labelApelidos.get(i).setForeground(Color.WHITE);
            labelApelidos.get(i).setBounds(419, 267 + posicao * i, 308, 38);
            this.add(labelApelidos.get(i));
        }
        /* FIM APELIDO */

        /* INICIO TEMPO TOTAL */
        labelTempoTot = new ArrayList<JLabel>();
        for (int i = 0; i < qtdJogadores; i++) {
            labelTempoTot.add(new JLabel(jogo.getListaJogadores().get(i).getTempoTotalJogado() + ""));
            labelTempoTot.get(i).setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
            labelTempoTot.get(i).setForeground(Color.WHITE);
            labelTempoTot.get(i).setBounds(786, 267 + posicao * i, 136, 38);
            this.add(labelTempoTot.get(i));
        }

        /* FIM TEMPO TOTAL */

        /* INICIO PONTOS TOTAL */
        labelPontosTot = new ArrayList<JLabel>();
        for (int i = 0; i < qtdJogadores; i++) {
            labelPontosTot.add(new JLabel(jogo.getListaJogadores().get(i).getPontos() + "")); // temporariamente alterado para
                                                                                     // pontos da partida não record
                                                                                     // pessoal
            labelPontosTot.get(i).setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
            labelPontosTot.get(i).setForeground(Color.WHITE);
            labelPontosTot.get(i).setBounds(986, 267 + posicao * i, 152, 38);
            this.add(labelPontosTot.get(i));
        }
        /* FIM PONTOS TOTAL */

        /* INICIO MELHOR JOGADA */
        labelMelhorJgd = new ArrayList<JLabel>();
        for (int i = 0; i < qtdJogadores; i++) {
            labelMelhorJgd.add(new JLabel(jogo.getListaJogadores().get(i).getJogadaMaisRapidaEmUnidadedeTempo() + ""));
            labelMelhorJgd.get(i).setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
            labelMelhorJgd.get(i).setForeground(Color.WHITE);
            labelMelhorJgd.get(i).setBounds(1223, 267 + posicao * i, 116, 38);
            this.add(labelMelhorJgd.get(i));
        }
        /* FIM MELHOR JOGADA */
    }

}
