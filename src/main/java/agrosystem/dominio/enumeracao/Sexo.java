package agrosystem.dominio.enumeracao;

public enum Sexo {
	
    MACHO("Macho"),
    FEMEA("Fêmea");

    private String sexo;

    private Sexo(String sexo) {
        this.sexo = sexo;
    }//Construtor

    
    public String getSexo() {
        return sexo;
    }//getSexo()
    
    public void setSexo(String sexo) {
		this.sexo = sexo;
	}//setSexo()

    public static Sexo converterStringParaSexo(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (Sexo sexo : Sexo.values()) {
            if (sexo.getSexo().equalsIgnoreCase(string)) {
                return sexo;
            }
        }
    	return null;
    }//converterStringParaSexo()
    
    @Override
    public String toString() {
        return getSexo();
    }//toString()
}//Sexo
