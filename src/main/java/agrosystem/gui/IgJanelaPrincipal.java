package agrosystem.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import agrosystem.dao.DAO;
import agrosystem.dominio.Bovino;
import agrosystem.dominio.enumeracao.Raca;
import agrosystem.dominio.enumeracao.Sexo;
import agrosystem.utilitarios.Utilitario;

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
	private JTable bovinosTabel;
	
	private List<Bovino> bovinoList;
	private int totalBovinos;
	private int totalMachos;
	private int totalFemeas;
	

	public IgJanelaPrincipal(DAO<Bovino> bovinoDAO) {
		this.bovinoList = bovinoDAO.listaTodos();
		totalBovinos = bovinoList.size();
		totalMachos = bovinoList.stream().filter( b -> b.getSexo() == Sexo.MACHO).toList().size();
		totalFemeas = bovinoList.stream().filter( b -> b.getSexo() == Sexo.FEMEA).toList().size();

		String[] racas = Raca.getRacas();
		String[] sexos = { "Macho", "Fêmea", "Todos"};

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IgJanelaPrincipal.class.getResource("/agrosystem/imagens/icon.png")));
		setTitle("Agro System™");

		// Define o tamanho da janela
		setBounds(100, 100, 1280, 521);
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
		bovinosTotalLabel.setForeground(new Color(150, 75, 0));
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
		bovinosTotalMachoLabel.setForeground(new Color(150, 75, 0));
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
		bovinosTotalFemeasLabel.setForeground(new Color(150, 75, 0));
		bovinosTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		bovinosTotalFemeasPanel.add(bovinosTotalFemeasLabel);

		valorTotalFemeasLabel = new JLabel();
		valorTotalFemeasLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		bovinosTotalFemeasPanel.add(valorTotalFemeasLabel);

		JPanel centralPanel = new JPanel();
		centralPanel.setBackground(new Color(255, 255, 255));
		centralPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Bovinos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		centralPanel.setBounds(6, 65, 1252, 383);
		contentPane.add(centralPanel);
		centralPanel.setLayout(null);

		graficoPanel = new JPanel();
		graficoPanel.setBounds(838, 55, 408, 304);
		centralPanel.add(graficoPanel);
		graficoPanel.setLayout(new BorderLayout(0, 0));

		tabelaPanel = new JPanel();
		tabelaPanel.setBackground(new Color(255, 255, 255));
		tabelaPanel.setBounds(6, 55, 826, 304);
		centralPanel.add(tabelaPanel);
		tabelaPanel.setLayout(new BorderLayout(0, 0));
		
		bovinosTabel = criarTabela();
		tabelaPanel.add(bovinosTabel);
		tabelaPanel.add(criarTabelaBovinos(bovinoList));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 16, 291, 30);
		centralPanel.add(panel);
		panel.setLayout(null);
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.setBounds(179, 6, 95, 21);
		panel.add(sexoComboBox);
		sexoComboBox.setModel(new DefaultComboBoxModel<>(sexos));
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
		racaComboBox.setSelectedIndex(4);
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
		InferiorPanel.setBounds(0, 448, 1264, 34);
		contentPane.add(InferiorPanel);

		consultarButton = new JButton("Pesquisar Bovino...");
		consultarButton.setMnemonic(KeyEvent.VK_P);
		consultarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		consultarButton.setBackground(Color.WHITE);

		cadastrarButton = new JButton("Cadastrar...");
		cadastrarButton.setMnemonic(KeyEvent.VK_C);
		cadastrarButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		cadastrarButton.setBackground(Color.WHITE);
		GroupLayout gl_InferiorPanel = new GroupLayout(InferiorPanel);
		gl_InferiorPanel.setHorizontalGroup(
			gl_InferiorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InferiorPanel.createSequentialGroup()
					.addGap(1013)
					.addComponent(cadastrarButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(consultarButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_InferiorPanel.setVerticalGroup(
			gl_InferiorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InferiorPanel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_InferiorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(consultarButton)
						.addComponent(cadastrarButton)))
		);
		InferiorPanel.setLayout(gl_InferiorPanel);
		
		
		
		//Atualiza os valores dos componentes exibidos na GUI.
		atualizarComponentes();
		
		//Atualiza os componentes de acordo com a raça selecionada no JComboBox.
		racaComboBox.addItemListener((itemEvent) -> atualizarComponentes(itemEvent));
		
		//Atualiza os componentes de acordo com o sexo selecionado no JComboBox.
		sexoComboBox.addItemListener((itemEvent) -> atualizarComponentes(itemEvent));
		
		//Abre a janela de Cadastro.
		cadastrarButton.addActionListener((e) -> {
		    // Instanciar a janela de cadastro
		    new IgCadastro(IgJanelaPrincipal.this, bovinoDAO, bovinoList);
		    atualizarComponentes();
		});
		
		//Abre a janela de pesquisa
		consultarButton.addActionListener((e) -> new IgPesquisa(IgJanelaPrincipal.this, bovinosTabel, bovinoList));
		
		//Atualiza os componentes quando a janela volta para o foco.
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				atualizarComponentes();
			}
		});
		
		
		
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
	
	private void atualizarComponentes() {
		List<Bovino> bovinoLista = bovinoList;
		
		if (bovinoList.isEmpty()) {
			consultarButton.setEnabled(false);
		}
		else {
			consultarButton.setEnabled(true);
		}
		
		if (!racaComboBox.getSelectedItem().equals("Todas")) {
			bovinoLista = bovinoLista.stream().filter((b) -> b.getRaca()
			.equals(Raca.converterStringParaRaca(racaComboBox.getSelectedItem().toString())))
			.collect(Collectors.toList());
		}
		
		if (!sexoComboBox.getSelectedItem().equals("Todos")) {
			bovinoLista = bovinoLista.stream().filter((b) -> b.getSexo()
			.equals(Sexo.converterStringParaSexo(sexoComboBox.getSelectedItem().toString())))
			.collect(Collectors.toList());
		}
		graficoEmBarras();
		
		atualizarTabela(bovinoLista);
		
		// Remover o JScrollPane antigo da tabelaPanel
		tabelaPanel.remove(0);

		// Adicionar o novo JScrollPane à tabelaPanel
		tabelaPanel.add(atualizarTabela(bovinoLista));
				
		// Atualizar a interface
		tabelaPanel.revalidate();
		tabelaPanel.repaint();
		
		atualizarValoresLabels();
	}//atualizarComponentes()
	
	
	private void atualizarComponentes(ItemEvent itemEvent) {
		if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
			atualizarComponentes();
		}
	}//atualizarComponentes()
	
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
	
	
	private JTable criarTabela() {
		
		// Criar a tabela com o modelo criado
		JTable tabela = new JTable(new DefaultTableModel(
		        new Object[][] {
		        },
		        new String[] {
		            "Brinco", "Nome", "Situação", "Sexo", "Brinco Mãe",  "Brinco Pai", "Raça", "Nascimento", 
		            "Prenhês", "Próximo P", "Último P"
		        }
		    )) {
				private static final long serialVersionUID = 1L;

				@Override
		        public boolean isCellEditable(int row, int column) {
		            // Todas as células não são editáveis
		            return false;
		        }
		    };

		// Impedir reordenação das colunas
		tabela.getTableHeader().setReorderingAllowed(false);

		// Configurar o estilo da tabela
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Preencher toda a altura da tabela
		tabela.setFillsViewportHeight(true);

		// Definir cor de fundo da tabela
		tabela.setBackground(Color.WHITE);

		// Remover sombra da linha quando uma célula é selecionada
		tabela.setRowSelectionAllowed(true);

		// Definir cor de fundo do cabeçalho da tabela
		tabela.getTableHeader().setBackground(Color.WHITE);

		// Adicionar bordas entre as colunas e linhas da tabela
		tabela.setShowGrid(true);
		tabela.setGridColor(Color.LIGHT_GRAY);
		
		tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(70);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(70);

		return tabela;
	}//criarTabela()
	
	public JScrollPane criarTabelaBovinos(List<Bovino> bovinoList) {
		JScrollPane scrollPane = atualizarTabela(bovinoList);
		return scrollPane;
	}//criarTabelaBovinos()
	
	private JScrollPane atualizarTabela(List<Bovino> bovinoList) {
		DefaultTableModel model = (DefaultTableModel) bovinosTabel.getModel();
		
		// Limpar dados existentes da tabela
		model.setRowCount(0);
		
		for(Bovino bovino : bovinoList) {
			Object[] rowData = {
					bovino.getBrinco(),
					bovino.getNome(),
					bovino.getSituacao().toString(),
					bovino.getSexo() == Sexo.MACHO ? "M" : "F",
					bovino.getBrincoPai(),
					bovino.getBrincoPai(),
					bovino.getRaca().toString(),
					bovino.getDataNascimento().format(Utilitario.DIA_MES_ANO_FORMATTER),
					bovino.getDataPrenhes() != null ? bovino.getDataPrenhes().format(Utilitario.DIA_MES_ANO_FORMATTER) : "",
					bovino.getDataPrenhes() != null ? bovino.getDataPrenhes().plusMonths(9).format(Utilitario.DIA_MES_ANO_FORMATTER) : "",
					bovino.getDataUltimoParto() != null ? bovino.getDataUltimoParto().format(Utilitario.DIA_MES_ANO_FORMATTER) : ""
					
			};
			model.addRow(rowData);
		}
		
		// Criar um JScrollPane para permitir a rolagem da tabela
		JScrollPane scrollPane = new JScrollPane(bovinosTabel);
				
		return scrollPane;
	}//atualizarTabela()
}
