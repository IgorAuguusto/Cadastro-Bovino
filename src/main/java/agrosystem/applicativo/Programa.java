package agrosystem.applicativo;

import java.util.Locale;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import agrosystem.dao.DAO;
import agrosystem.dominio.Bovino;
import agrosystem.gui.IgJanelaPrincipal;

public class Programa {

	public static void main(String[] args) {
		agroSystem();
	}//main()

	private static void agroSystem() {
		try {
			Locale.setDefault(new Locale("pt", "BR"));
			DAO<Bovino> bovinoDAO = new DAO<>(Bovino.class);
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			new IgJanelaPrincipal(bovinoDAO);
		}
		catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro inesperado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}//agroSystem()

}//Programa
