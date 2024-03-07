package agrosystem.dominio.enumeracao;

import java.util.ArrayList;
import java.util.List;

public enum Raca {
	GIROLANDO("Girolando"),
    HOLANDES("Holandês"),
    GIR("Gir"),
    JERSEY("Jersey");

    	
    private String raca;

    private Raca(String raca) {
        this.raca = raca;
    }//Construtor

    
    public String getRaca() {
        return raca;
    }//getRaca()
    
    public void setRaca(String raca) {
		this.raca = raca;
	}//setRaca()

    public static Raca converterStringParaRaca(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (Raca raca : Raca.values()) {
            if (raca.getRaca().equalsIgnoreCase(string)) {
                return raca;
            }
        }
    	return null;
    }//converterStringParaRaca()
    
    public static String[] getRacas() {
    	Raca[] racas = Raca.values();
        List<String> nomeRacas = new ArrayList<>();

        for (Raca raca : racas) {
        	nomeRacas.add(raca.getRaca());
        }
        nomeRacas.add("Todas");
        return nomeRacas.toArray(new String[0]);
    }//getRacas()
    
    @Override
    public String toString() {
        return getRaca();
    }//toString()
}//Raca
