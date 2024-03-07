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

public class IgCadastro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	
	public IgCadastro() {
		setBounds(100, 100, 450, 562);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 488, 434, 35);
		contentPanel.add(panel);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(248, 5, 90, 28);
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		cadastrarButton.setMnemonic(KeyEvent.VK_D);
		cadastrarButton.setBackground(Color.WHITE);
		panel.add(cadastrarButton);
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(338, 5, 90, 28);
		cancelarButton.setMnemonic(KeyEvent.VK_C);
		cancelarButton.setBackground(Color.WHITE);
		panel.add(cancelarButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192)), "Cadastro de Bovino", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(6, 0, 422, 490);
		contentPanel.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel brincoLabel = new JLabel("Brinco:");
		brincoLabel.setBounds(16, 29, 47, 16);
		mainPanel.add(brincoLabel);
		
		textField = new JTextField();
		textField.setBounds(63, 23, 275, 28);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(63, 57, 275, 28);
		mainPanel.add(textField_1);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(16, 63, 47, 16);
		mainPanel.add(lblNome);
		
		JLabel lblSituao = new JLabel("Situação:");
		lblSituao.setBounds(16, 97, 70, 16);
		mainPanel.add(lblSituao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(73, 92, 240, 26);
		mainPanel.add(comboBox);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(16, 125, 52, 16);
		mainPanel.add(lblSexo);
	}
}
