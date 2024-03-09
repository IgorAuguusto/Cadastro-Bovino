package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import agrosystem.dao.DAO;
import agrosystem.dominio.Bovino;
import agrosystem.dominio.enumeracao.Raca;
import agrosystem.dominio.enumeracao.Situacao;

public class IgCadastro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField brincoMaeField;
	private JTextField brincoPaiField;
	private JLabel brincoDaMaeLabel;
	private JLabel brincoDoPaiLabel;
	private DAO<Bovino> bovinoDao;
	private JRadioButton machoNewRadioButton;
	private JRadioButton femeaNewRadioButton;
	private JTextField brincoField;
	private JLabel brincoLabel;
	private JTextField nomeField;
	private JLabel nomeLabel;
	private JLabel situaoLabel;
	private JComboBox<String> situacaoComboBox;
	private JLabel racaLabel;
	private JComboBox<String> racaComboBox;
	private JTextField dataNascimentoField;
	private JLabel dataNascimentoLabel;
	private JLabel sexoLabel;
	private JTextField dataPrenhesField;
	private JLabel dataPrenhesLabel;
	private JTextField dataProximoPartoField;
	private JLabel dataProximoPartoLabel;
	private JTextField dataUltimoPartoField;
	private JLabel dataUltimoPartoLabel;

	
	public IgCadastro(Component janelaPai, DAO<Bovino> bovinoDao) {
		this.bovinoDao = bovinoDao;
		String[] situacoes = Situacao.getSituacoes();
		String[] racas = Raca.getRacas();
		racas = Arrays.copyOfRange(racas, 0, racas.length - 1);
		
		setTitle("Agro System");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IgJanelaPrincipal.class.getResource("/agrosystem/imagens/icon.png")));
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
		cancelarButton.setActionCommand("Cancel");
		panel.add(cancelarButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Cadastro de Bovino", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(6, 0, 362, 381);
		contentPanel.add(mainPanel);
		mainPanel.setLayout(null);
		
		brincoLabel = new JLabel("Brinco:");
		brincoLabel.setDisplayedMnemonic(KeyEvent.VK_B);
		brincoLabel.setBounds(16, 29, 47, 16);
		mainPanel.add(brincoLabel);
		
		brincoField = new JTextField();
		brincoLabel.setLabelFor(brincoField);
		brincoField.setBounds(63, 23, 275, 28);
		mainPanel.add(brincoField);
		brincoField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(63, 57, 275, 28);
		mainPanel.add(nomeField);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nomeLabel.setLabelFor(nomeField);
		nomeLabel.setBounds(16, 63, 47, 16);
		mainPanel.add(nomeLabel);
		
		situaoLabel = new JLabel("Situação:");
		situaoLabel.setDisplayedMnemonic(KeyEvent.VK_S);
		situaoLabel.setBounds(16, 152, 70, 16);
		mainPanel.add(situaoLabel);
		
		situacaoComboBox = new JComboBox<>();
		situacaoComboBox.setModel(new DefaultComboBoxModel<>(situacoes));
		situaoLabel.setLabelFor(situacaoComboBox);
		situacaoComboBox.setBounds(74, 147, 149, 26);
		mainPanel.add(situacaoComboBox);
		
		brincoDaMaeLabel = new JLabel("Brinco da Mãe:");
		brincoDaMaeLabel.setDisplayedMnemonic(KeyEvent.VK_M);
		brincoDaMaeLabel.setLabelFor(brincoDaMaeLabel);
		brincoDaMaeLabel.setBounds(16, 91, 98, 16);
		mainPanel.add(brincoDaMaeLabel);
		
		brincoMaeField = new JTextField();
		brincoMaeField.setColumns(10);
		brincoMaeField.setBounds(105, 85, 233, 28);
		mainPanel.add(brincoMaeField);
		
		brincoDoPaiLabel = new JLabel("Brinco do Pai:");
		brincoDoPaiLabel.setDisplayedMnemonic(KeyEvent.VK_P);
		brincoDoPaiLabel.setBounds(16, 124, 98, 16);
		mainPanel.add(brincoDoPaiLabel);
		
		brincoPaiField = new JTextField();
		brincoDoPaiLabel.setLabelFor(brincoPaiField);
		brincoPaiField.setColumns(10);
		brincoPaiField.setBounds(105, 119, 233, 28);
		mainPanel.add(brincoPaiField);
		
		racaLabel = new JLabel("Raça:");
		racaLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		racaLabel.setBounds(16, 185, 70, 16);
		mainPanel.add(racaLabel);
		
		racaComboBox = new JComboBox<>();
		racaComboBox.setModel(new DefaultComboBoxModel<>(racas));
		racaLabel.setLabelFor(racaComboBox);
		racaComboBox.setBounds(74, 180, 149, 26);
		mainPanel.add(racaComboBox);
		
		dataNascimentoLabel = new JLabel("Data Nascimento:");
		dataNascimentoLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		dataNascimentoLabel.setBounds(16, 218, 114, 16);
		mainPanel.add(dataNascimentoLabel);
		
		dataNascimentoField = new JTextField();
		dataNascimentoLabel.setLabelFor(dataNascimentoField);
		dataNascimentoField.setColumns(10);
		dataNascimentoField.setBounds(126, 212, 212, 28);
		mainPanel.add(dataNascimentoField);
		
		sexoLabel = new JLabel("Sexo:");
		sexoLabel.setBounds(16, 246, 70, 16);
		mainPanel.add(sexoLabel);
		
		machoNewRadioButton = new JRadioButton("Macho");
		
		buttonGroup.add(machoNewRadioButton);
		machoNewRadioButton.setSelected(true);
		machoNewRadioButton.setMnemonic(KeyEvent.VK_O);
		machoNewRadioButton.setBounds(140, 245, 83, 18);
		mainPanel.add(machoNewRadioButton);
		
		femeaNewRadioButton = new JRadioButton("Femea");
		buttonGroup.add(femeaNewRadioButton);
		femeaNewRadioButton.setMnemonic(KeyEvent.VK_F);
		femeaNewRadioButton.setBounds(235, 245, 83, 18);
		mainPanel.add(femeaNewRadioButton);
		
		dataPrenhesLabel = new JLabel("Data da Prenhês:");
		dataPrenhesLabel.setDisplayedMnemonic(KeyEvent.VK_E);
		dataPrenhesLabel.setBounds(16, 274, 114, 16);
		mainPanel.add(dataPrenhesLabel);
		
		dataPrenhesField = new JTextField();
		dataPrenhesLabel.setLabelFor(dataPrenhesField);
		dataPrenhesField.setColumns(10);
		dataPrenhesField.setBounds(126, 268, 212, 28);
		mainPanel.add(dataPrenhesField);
		
		dataProximoPartoLabel = new JLabel("Data Próximo Parto:");
		dataProximoPartoLabel.setDisplayedMnemonic(KeyEvent.VK_X);
		dataProximoPartoLabel.setBounds(16, 308, 114, 16);
		mainPanel.add(dataProximoPartoLabel);
		
		dataProximoPartoField = new JTextField();
		dataProximoPartoLabel.setLabelFor(dataProximoPartoField);
		dataProximoPartoField.setColumns(10);
		dataProximoPartoField.setBounds(126, 302, 212, 28);
		mainPanel.add(dataProximoPartoField);
		
		dataUltimoPartoLabel = new JLabel("Data Último Parto:");
		dataUltimoPartoLabel.setDisplayedMnemonic(KeyEvent.VK_L);
		dataUltimoPartoLabel.setBounds(16, 336, 114, 16);
		mainPanel.add(dataUltimoPartoLabel);
		
		dataUltimoPartoField = new JTextField();
		dataUltimoPartoLabel.setLabelFor(dataUltimoPartoField);
		dataUltimoPartoField.setColumns(10);
		dataUltimoPartoField.setBounds(126, 336, 212, 28);
		mainPanel.add(dataUltimoPartoField);
		
		//Fecha a janela quando o botão cancelar for precionado.
		cancelarButton.addActionListener((e) -> dispose());
		
		//desativa os campos do Bovino femea.
		desativarOpcoesBovinoFemea();
		
		//Desabilita os campos das Femeas
		machoNewRadioButton.addActionListener((e) -> acaoRadioButton());
		
		//Habilita os campos das Femeas
		femeaNewRadioButton.addActionListener((e) -> acaoRadioButton());
		
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}//Construtor
	
	private void acaoRadioButton() {
		if (machoNewRadioButton.isSelected()) {
			desativarOpcoesBovinoFemea();
		}
		else {
			ativarOpcoesBovinoFemea();
		}
	}//acaoRadioButton()

	private void desativarOpcoesBovinoFemea() {
		dataPrenhesField.setEnabled(false);
		dataProximoPartoField.setEnabled(false);
		dataUltimoPartoField.setEnabled(false);
	}//desativarOpcoesBovinoFemea()
	
	private void ativarOpcoesBovinoFemea() {
		dataPrenhesField.setEnabled(true);
		dataProximoPartoField.setEnabled(true);
		dataUltimoPartoField.setEnabled(true);
	}//ativarOpcoesBovinoFemea()
}//IgCadastro
