package agrosystem.utilitarios;

import java.time.format.DateTimeFormatter;

public class Utilitario {
	
	/**
	 * {@code DateTimeFormatter} no formato dd/MM/yyyy.
	 */
	public static final DateTimeFormatter DIA_MES_ANO_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/**
	 * {@code String} que representa regex de uma data no formato dd/MM/yyyy onde dd, mm e yyyy são números.
	 */
	public static final String DATA_PATTERN = "^\\d{2}/\\d{2}/\\d{4}$";
	
	public static final String BRINCO_PATTERN = "[a-zA-Z0-9]{8}";
	
	public static final String NOME_PATTERN = "[a-zA-Z0-9]{1,20}";

}//Utilitario
