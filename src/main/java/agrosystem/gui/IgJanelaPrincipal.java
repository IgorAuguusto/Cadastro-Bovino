package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import agrosystem.dao.DAO;
import agrosystem.dominio.Bovino;
import agrosystem.dominio.enumeracao.Raca;
import agrosystem.dominio.enumeracao.Sexo;

public class IgJanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel tabelaPanel;
	private JLabel bovinosTotalLabel;
	private JLabel valorTotalBovinosLabel;
	private JLabel bovinosTotalMachoLabel;
	private JLabel valorTotalMachosLabel;
	private JLabel bovinosTotalFemeasLabel;
	private JLabel valorTotalFemeasLabel;
	private JLabel racaLabel;
	private JComboBox<String> racaComboBox;
	private JLabel sexoLabel;
	private JComboBox<String> sexoComboBox;
	private JPanel graficoPanel;
	private JButton cadastrarButton;
	private JButton consultarButton;
	
	private DAO<Bovino> bovinoDAO;
	private List<Bovino> bovinoList;
	private int totalBovinos;
	private int totalMachos;
	private int totalFemeas;

	public IgJanelaPrincipal(DAO<Bovino> bovinoDAO) {
		this.bovinoDAO = bovinoDAO;
		this.bovinoList = bovinoDAO.listaTodos();
		totalBovinos = bovinoList.size();
		totalMachos = bovinoList.stream().filter( b -> b.getSexo() == Sexo.MACHO).toList().size();
		totalFemeas = bovinoList.stream().filter( b -> b.getSexo() == Sexo.FEMEA).toList().size();

		String[] racas = Raca.getRacas();
		String[] sexo = { "Macho", "Fêmea", "Todas"};

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IgJanelaPrincipal.class.getResource("/agrosystem/imagens/icon.png")));
		setTitle("Agro System™");

		// Define o tamanho da janela
		setBounds(100, 100, 1000, 521);
		setResizable(false);
		setVisible(true);
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

		bovinosTotalLabel = new JLabel("Total de Bovinos");
		bovinosTotalLabel.setForeground(Color.BLUE);
		bovinosTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosTotalPanel.add(bovinosTotalLabel);

		valorTotalBovinosLabel = new JLabel();
		valorTotalBovinosLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosTotalPanel.add(valorTotalBovinosLabel);

		JPanel bovinosMachosTotalPanel = new JPanel();
		bovinosMachosTotalPanel.setBackground(Color.WHITE);
		bovinosMachosTotalPanel.setBounds(199, 0, 144, 59);
		superiorPanel.add(bovinosMachosTotalPanel);

		bovinosTotalMachoLabel = new JLabel("Total de Machos");
		bovinosTotalMachoLabel.setForeground(Color.BLUE);
		bovinosTotalMachoLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosMachosTotalPanel.add(bovinosTotalMachoLabel);

		valorTotalMachosLabel = new JLabel();
		valorTotalMachosLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosMachosTotalPanel.add(valorTotalMachosLabel);

		JPanel bovinosTotalFemeasPanel = new JPanel();
		bovinosTotalFemeasPanel.setBackground(Color.WHITE);
		bovinosTotalFemeasPanel.setBounds(380, 0, 144, 59);
		superiorPanel.add(bovinosTotalFemeasPanel);

		bovinosTotalFemeasLabel = new JLabel("Total de Fêmeas");
		bovinosTotalFemeasLabel.setForeground(Color.BLUE);
		bovinosTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosTotalFemeasPanel.add(bovinosTotalFemeasLabel);

		valorTotalFemeasLabel = new JLabel();
		valorTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosTotalFemeasPanel.add(valorTotalFemeasLabel);

		JPanel centralPanel = new JPanel();
		centralPanel.setBackground(new Color(255, 255, 255));
		centralPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Bovinos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		centralPanel.setBounds(6, 65, 972, 383);
		contentPane.add(centralPanel);
		centralPanel.setLayout(null);

		graficoPanel = new JPanel();
		graficoPanel.setBounds(539, 55, 427, 304);
		centralPanel.add(graficoPanel);
		graficoPanel.setLayout(new BorderLayout(0, 0));

		tabelaPanel = new JPanel();
		tabelaPanel.setBounds(6, 55, 527, 304);
		centralPanel.add(tabelaPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 16, 291, 30);
		centralPanel.add(panel);
		panel.setLayout(null);
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.setBounds(179, 6, 95, 21);
		panel.add(sexoComboBox);
		sexoComboBox.setModel(new DefaultComboBoxModel<>(sexo));
		sexoComboBox.setSelectedIndex(2);
		sexoComboBox.setMaximumRowCount(3);
		sexoComboBox.setBorder(null);
		sexoComboBox.setBackground(Color.WHITE);
		
		sexoLabel = new JLabel("Sexo:");
		sexoLabel.setBounds(146, 8, 34, 16);
		panel.add(sexoLabel);
		sexoLabel.setDisplayedMnemonic(KeyEvent.VK_S);
		sexoLabel.setLabelFor(sexoComboBox);
		
		racaComboBox = new JComboBox<String>();
		racaComboBox.setBounds(39, 6, 95, 21);
		panel.add(racaComboBox);
		racaComboBox.setModel(new DefaultComboBoxModel<>(racas));
		racaComboBox.setSelectedIndex(3);
		racaComboBox.setMaximumRowCount(5);
		racaComboBox.setBorder(null);
		racaComboBox.setBackground(Color.WHITE);
		
		racaLabel = new JLabel("Raça:");
		racaLabel.setBounds(6, 8, 34, 16);
		panel.add(racaLabel);
		racaLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		racaLabel.setLabelFor(racaComboBox);

		JPanel InferiorPanel = new JPanel();
		InferiorPanel.setBackground(new Color(255, 255, 255));
		InferiorPanel.setBounds(0, 448, 984, 34);
		contentPane.add(InferiorPanel);

		consultarButton = new JButton("Pesquisar Bovino...");
		consultarButton.setMnemonic(KeyEvent.VK_P);
		consultarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		consultarButton.setBackground(Color.WHITE);

		cadastrarButton = new JButton("Cadastrar...");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cadastrarButton.setMnemonic(KeyEvent.VK_C);
		cadastrarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		cadastrarButton.setBackground(Color.WHITE);
		GroupLayout gl_InferiorPanel = new GroupLayout(InferiorPanel);
		gl_InferiorPanel.setHorizontalGroup(
			gl_InferiorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InferiorPanel.createSequentialGroup()
					.addGap(737)
					.addComponent(cadastrarButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(consultarButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
		);
		gl_InferiorPanel.setVerticalGroup(
			gl_InferiorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InferiorPanel.createSequentialGroup()
					.addGap(3)
					.addComponent(cadastrarButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_InferiorPanel.createSequentialGroup()
					.addGap(2)
					.addComponent(consultarButton))
		);
		InferiorPanel.setLayout(gl_InferiorPanel);
		
		atualizarValoresLabels();
		
		graficoEmBarras();

		// Fecha a conexão com banco de dados quando o programa for finalizado
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					bovinoDAO.close();
				} catch (Exception e1) {
					JOptionPane.showInternalConfirmDialog(IgJanelaPrincipal.this,
							"Error ao fechar conexão com banco de dados", "Error", JOptionPane.ERROR_MESSAGE);
				}
				System.exit(0);
			}
		});
	}//IgJanelaPrincipal()
	
	private void atualizarValoresLabels() {
		valorTotalBovinosLabel.setText(String.valueOf(totalBovinos));
		valorTotalMachosLabel.setText(String.valueOf(totalMachos));
		valorTotalFemeasLabel.setText(String.valueOf(totalFemeas));
	}//atualizarValoresLabels()
	
	
	private void graficoEmBarras() {
		graficoPanel.add(IgGraficoBarras.gerarGraficoBarras(bovinoList, totalBovinos));
		tabelaPanel.revalidate();
		tabelaPanel.repaint();
	}//graficoEmBarras()
}
