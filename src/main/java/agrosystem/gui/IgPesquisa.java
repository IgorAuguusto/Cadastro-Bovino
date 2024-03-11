package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import agrosystem.dominio.Bovino;


/**
 * Classe responsável pela interface gráfica de pesquisa de Bovino.
 */
public class IgPesquisa extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField itemBovinoTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton brincoJRadioButton;
	private JRadioButton nomeJRadioButton;
	private Component janelaPai;
	private JTable tabela;
	List<Bovino> bovinoList;
	private int indice;

	/**
	 * Cria uma nova janela de pesquisa de Bovino.
	 *
	 * @param janelaPai    A janela pai à qual esta janela está vinculada.
	 * @param tabela       A tabela de Bovinos onde a pesquisa será realizada.
	 * @param bovinoList  A lista de Bovinos a serem pesquisadas.
	 */
	public IgPesquisa(Component janelaPai, JTable tabela, List<Bovino> bovinoList) {
		this.janelaPai = janelaPai;
		this.tabela = tabela;
		this.bovinoList = bovinoList;

		setTitle("Pesquisar Bovino");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IgPesquisa.class.getResource("/agrosystem/imagens/icon.png")));

		final Font ESTILO_FONTES = new Font("SansSerif", Font.PLAIN, 12);

		setBounds(100, 100, 286, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel itemDeBovinoLabel = new JLabel("Bovino: ");
		itemDeBovinoLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		itemDeBovinoLabel.setFont(ESTILO_FONTES);
		itemDeBovinoLabel.setBounds(10, 11, 109, 24);
		contentPanel.add(itemDeBovinoLabel);

		itemBovinoTextField = new JTextField();
		itemDeBovinoLabel.setLabelFor(itemBovinoTextField);
		itemBovinoTextField.setBounds(87, 11, 176, 24);
		contentPanel.add(itemBovinoTextField);
		itemBovinoTextField.setColumns(10);

		JLabel procurarBovinoLabel = new JLabel("Procurar por: ");
		procurarBovinoLabel.setFont(ESTILO_FONTES);
		procurarBovinoLabel.setBounds(10, 45, 74, 14);
		contentPanel.add(procurarBovinoLabel);

		brincoJRadioButton = new JRadioButton("Brinco");
		buttonGroup.add(brincoJRadioButton);
		brincoJRadioButton.setMnemonic(KeyEvent.VK_B);
		brincoJRadioButton.setFont(ESTILO_FONTES);
		brincoJRadioButton.setBackground(Color.WHITE);
		brincoJRadioButton.setBounds(87, 41, 83, 23);
		contentPanel.add(brincoJRadioButton);

		nomeJRadioButton = new JRadioButton("Nome");
		buttonGroup.add(nomeJRadioButton);
		nomeJRadioButton.setMnemonic(KeyEvent.VK_N);
		nomeJRadioButton.setFont(ESTILO_FONTES);
		nomeJRadioButton.setBackground(Color.WHITE);
		nomeJRadioButton.setBounds(182, 41, 81, 23);
		contentPanel.add(nomeJRadioButton);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton proximaBovinoButton = new JButton("Próxima Bovino");

		proximaBovinoButton.setBackground(Color.WHITE);
		proximaBovinoButton.setMnemonic(KeyEvent.VK_P);
		proximaBovinoButton.setActionCommand("");
		buttonPane.add(proximaBovinoButton);
		getRootPane().setDefaultButton(proximaBovinoButton);

		JButton cancelButton = new JButton("Fechar");

		nomeJRadioButton.setSelected(true);

		cancelButton.addActionListener((e) -> dispose());

		indice = 0;

		itemBovinoTextField.addActionListener((e) -> pesquisarBovinos(true));

		proximaBovinoButton.addActionListener((e) -> pesquisarBovinos(false));

		cancelButton.setBackground(Color.WHITE);
		cancelButton.setMnemonic(KeyEvent.VK_F);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		setModal(true);
		setResizable(false);
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}//Construtor

	/**
	 * Realiza a pesquisa de Bovinos com base nos critérios fornecidos.
	 *
	 * @param primeiraVez Indica se é a primeira vez que a pesquisa está sendo realizada.
	 */
	private void pesquisarBovinos(boolean primeiraVez) {
		String itemASerPesquisado = itemBovinoTextField.getText();
		if (primeiraVez) {
			indice = 0;
		}

		int numeroDeLinhas = tabela.getRowCount();

		if (brincoJRadioButton.isSelected()) {
			for (int i = indice; i < numeroDeLinhas; i++) {
				Object objeto = tabela.getValueAt(i, 0);
				if (objeto != null) {
					if (objeto.toString().equalsIgnoreCase(itemASerPesquisado)) {
						janelaPai.requestFocus();
						tabela.changeSelection(i, 0, false, false);
						tabela.requestFocusInWindow();
						indice = i + 1;
						return;
					}
				}
			}
		} else if (nomeJRadioButton.isSelected()) {

			for (int i = indice; i < numeroDeLinhas; i++) {
				Object objeto = tabela.getValueAt(i, 1);
				if (objeto != null) {
					if (objeto.toString().equalsIgnoreCase(itemASerPesquisado)) {
						janelaPai.requestFocus();
						tabela.changeSelection(i, 1, false, false);
						tabela.requestFocusInWindow();
						indice = i +1;
						return;
					}
				}

			}
		}
		
		if (indice == 0) {
			JOptionPane.showMessageDialog(this, "Nenhum Bovino foi encontrada", "Pesquesa Bovino", JOptionPane.INFORMATION_MESSAGE);
		}
	}//pesquisarBovinos()
}//IgPesquisa
