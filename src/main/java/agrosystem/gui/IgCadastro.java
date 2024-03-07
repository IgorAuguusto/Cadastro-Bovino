package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class IgCadastro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField brincoMaeField;
	private JTextField brincoPaiField;
	private JLabel brincoDaMaeLabel;
	private JLabel brincoDoPaiLabel;

	
	public IgCadastro() {
		setBounds(100, 100, 390, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 380, 368, 35);
		contentPanel.add(panel);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(187, 5, 90, 28);
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		cadastrarButton.setMnemonic(KeyEvent.VK_D);
		cadastrarButton.setBackground(Color.WHITE);
		panel.add(cadastrarButton);
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(278, 5, 90, 28);
		cancelarButton.setMnemonic(KeyEvent.VK_C);
		cancelarButton.setBackground(Color.WHITE);
		panel.add(cancelarButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Cadastro de Bovino", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(6, 0, 362, 381);
		contentPanel.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel brincoLabel = new JLabel("Brinco:");
		brincoLabel.setBounds(16, 29, 47, 16);
		mainPanel.add(brincoLabel);
		
		JTextField brincoField = new JTextField();
		brincoField.setBounds(63, 23, 275, 28);
		mainPanel.add(brincoField);
		brincoField.setColumns(10);
		
		JTextField nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(63, 57, 275, 28);
		mainPanel.add(nomeField);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(16, 63, 47, 16);
		mainPanel.add(nomeLabel);
		
		JLabel situaoLabel = new JLabel("Situação:");
		situaoLabel.setBounds(16, 152, 70, 16);
		mainPanel.add(situaoLabel);
		
		JComboBox situacaoComboBox = new JComboBox();
		situacaoComboBox.setBounds(74, 147, 149, 26);
		mainPanel.add(situacaoComboBox);
		
		brincoDaMaeLabel = new JLabel("Brinco da Mãe:");
		brincoDaMaeLabel.setBounds(16, 91, 98, 16);
		mainPanel.add(brincoDaMaeLabel);
		
		brincoMaeField = new JTextField();
		brincoMaeField.setColumns(10);
		brincoMaeField.setBounds(105, 85, 233, 28);
		mainPanel.add(brincoMaeField);
		
		brincoDoPaiLabel = new JLabel("Brinco do Pai:");
		brincoDoPaiLabel.setBounds(16, 124, 98, 16);
		mainPanel.add(brincoDoPaiLabel);
		
		brincoPaiField = new JTextField();
		brincoPaiField.setColumns(10);
		brincoPaiField.setBounds(105, 119, 233, 28);
		mainPanel.add(brincoPaiField);
		
		JLabel racaLabel = new JLabel("Raça:");
		racaLabel.setBounds(16, 185, 70, 16);
		mainPanel.add(racaLabel);
		
		JComboBox racaComboBox = new JComboBox();
		racaComboBox.setBounds(74, 180, 149, 26);
		mainPanel.add(racaComboBox);
		
		JLabel dataNascimentoLabel = new JLabel("Data Nascimento:");
		dataNascimentoLabel.setBounds(16, 218, 114, 16);
		mainPanel.add(dataNascimentoLabel);
		
		JTextField dataNascimentoField = new JTextField();
		dataNascimentoField.setColumns(10);
		dataNascimentoField.setBounds(126, 212, 212, 28);
		mainPanel.add(dataNascimentoField);
		
		JLabel sexoLabel = new JLabel("Sexo:");
		sexoLabel.setBounds(16, 246, 70, 16);
		mainPanel.add(sexoLabel);
		
		JRadioButton machoNewRadioButton = new JRadioButton("Macho");
		machoNewRadioButton.setBounds(140, 245, 83, 18);
		mainPanel.add(machoNewRadioButton);
		
		JRadioButton femeaNewRadioButton = new JRadioButton("Femea");
		femeaNewRadioButton.setBounds(235, 245, 83, 18);
		mainPanel.add(femeaNewRadioButton);
		
		JLabel dataPrenhesLabel = new JLabel("Data da Prenhês:");
		dataPrenhesLabel.setBounds(16, 274, 114, 16);
		mainPanel.add(dataPrenhesLabel);
		
		JTextField dataPrenhesField = new JTextField();
		dataPrenhesField.setColumns(10);
		dataPrenhesField.setBounds(126, 268, 212, 28);
		mainPanel.add(dataPrenhesField);
		
		JLabel dataProximoPartoLabel = new JLabel("Data Próximo Parto:");
		dataProximoPartoLabel.setBounds(16, 308, 114, 16);
		mainPanel.add(dataProximoPartoLabel);
		
		JTextField dataProximoPartoField = new JTextField();
		dataProximoPartoField.setColumns(10);
		dataProximoPartoField.setBounds(126, 302, 212, 28);
		mainPanel.add(dataProximoPartoField);
		
		JLabel dataUltimoPartoLabel = new JLabel(" Data Último Parto:");
		dataUltimoPartoLabel.setBounds(16, 342, 114, 16);
		mainPanel.add(dataUltimoPartoLabel);
		
		JTextField dataUltimoPartoField = new JTextField();
		dataUltimoPartoField.setColumns(10);
		dataUltimoPartoField.setBounds(126, 336, 212, 28);
		mainPanel.add(dataUltimoPartoField);
	}//Construtor
}//IgCadastro
