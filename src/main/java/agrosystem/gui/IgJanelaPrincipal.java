package agrosystem.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class IgJanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public IgJanelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IgJanelaPrincipal.class.getResource("/agrosystem/imagens/icon.png")));
		setTitle("Agro System™");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Define o tamanho da janela
		setBounds(100, 100, 1000, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(new Color(255, 255, 255));
		superiorPanel.setBounds(0, 0, 984, 65);
		contentPane.add(superiorPanel);
		superiorPanel.setLayout(null);
		
		JPanel bovinosTotalPanel = new JPanel();
		bovinosTotalPanel.setBackground(Color.WHITE);
		bovinosTotalPanel.setBounds(10, 0, 144, 59);
		superiorPanel.add(bovinosTotalPanel);
		
		JLabel bovinosTotalLabel = new JLabel("Total de Bovinos");
		bovinosTotalLabel.setForeground(Color.BLUE);
		bovinosTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosTotalPanel.add(bovinosTotalLabel);
		
		JLabel valorTotalBovinosLabel = new JLabel();
		valorTotalBovinosLabel.setText("<dynamic>");
		valorTotalBovinosLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosTotalPanel.add(valorTotalBovinosLabel);
		
		JPanel bovinosMachosTotalPanel = new JPanel();
		bovinosMachosTotalPanel.setBackground(Color.WHITE);
		bovinosMachosTotalPanel.setBounds(199, 0, 144, 59);
		superiorPanel.add(bovinosMachosTotalPanel);
		
		JLabel bovinosTotalMachoLabel = new JLabel("Total de Machos");
		bovinosTotalMachoLabel.setForeground(Color.BLUE);
		bovinosTotalMachoLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosMachosTotalPanel.add(bovinosTotalMachoLabel);
		
		JLabel valorTotalMachosLabel = new JLabel();
		valorTotalMachosLabel.setText("<dynamic>");
		valorTotalMachosLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosMachosTotalPanel.add(valorTotalMachosLabel);
		
		JPanel bovinosTotalFemeasPanel = new JPanel();
		bovinosTotalFemeasPanel.setBackground(Color.WHITE);
		bovinosTotalFemeasPanel.setBounds(380, 0, 144, 59);
		superiorPanel.add(bovinosTotalFemeasPanel);
		
		JLabel bovinosTotalFemeasLabel = new JLabel("Total de Fêmeas");
		bovinosTotalFemeasLabel.setForeground(Color.BLUE);
		bovinosTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosTotalFemeasPanel.add(bovinosTotalFemeasLabel);
		
		JLabel valorTotalFemeasLabel = new JLabel();
		valorTotalFemeasLabel.setText("<dynamic>");
		valorTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosTotalFemeasPanel.add(valorTotalFemeasLabel);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBackground(new Color(255, 255, 255));
		centralPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Bovinos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		centralPanel.setBounds(6, 65, 972, 383);
		contentPane.add(centralPanel);
		centralPanel.setLayout(null);
		
		JPanel graficoPanel = new JPanel();
		graficoPanel.setBounds(626, 55, 340, 304);
		centralPanel.add(graficoPanel);
		
		JPanel tabelaPanel = new JPanel();
		tabelaPanel.setBounds(6, 55, 613, 304);
		centralPanel.add(tabelaPanel);
		
		JComboBox<String> racaComboBox = new JComboBox<String>();
		racaComboBox.setSelectedIndex(7);
		racaComboBox.setMaximumRowCount(6);
		racaComboBox.setBorder(null);
		racaComboBox.setBackground(Color.WHITE);
		racaComboBox.setBounds(55, 25, 95, 21);
		centralPanel.add(racaComboBox);
		
		JLabel racaLabel = new JLabel("Raça:");
		racaLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		racaLabel.setBounds(18, 27, 34, 16);
		centralPanel.add(racaLabel);
		
		JComboBox<String> sexoComboBox = new JComboBox<String>();
		sexoComboBox.setSelectedIndex(7);
		sexoComboBox.setMaximumRowCount(6);
		sexoComboBox.setBorder(null);
		sexoComboBox.setBackground(Color.WHITE);
		sexoComboBox.setBounds(199, 25, 95, 21);
		centralPanel.add(sexoComboBox);
		
		JLabel sexoLabel = new JLabel("Sexo:");
		sexoLabel.setDisplayedMnemonic(KeyEvent.VK_S);
		sexoLabel.setBounds(163, 27, 34, 16);
		centralPanel.add(sexoLabel);
		
		JPanel InferiorPanel = new JPanel();
		InferiorPanel.setBackground(new Color(255, 255, 255));
		InferiorPanel.setBounds(0, 448, 984, 34);
		contentPane.add(InferiorPanel);
		InferiorPanel.setLayout(null);
		
		JButton consultarButton = new JButton("Pesquisar Bovino...");
		consultarButton.setBounds(849, 2, 128, 27);
		consultarButton.setMnemonic(KeyEvent.VK_P);
		consultarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		consultarButton.setBackground(Color.WHITE);
		InferiorPanel.add(consultarButton);
		
		JButton cadastrarButton = new JButton("Cadastrar...");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrarButton.setMnemonic(KeyEvent.VK_C);
		cadastrarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		cadastrarButton.setBackground(Color.WHITE);
		cadastrarButton.setBounds(737, 3, 111, 25);
		InferiorPanel.add(cadastrarButton);
	}
}
