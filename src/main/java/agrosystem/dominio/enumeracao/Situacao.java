package agrosystem.dominio.enumeracao;

import java.util.ArrayList;
import java.util.List;

public enum Situacao {

    
    LACTACAO("Em Lactação"),
    SECA("Seca"),
    VENDIDO("Vendido"),
    MORTO("Morto");

    	
    private String situacao;

    private Situacao(String situacao) {
        this.situacao = situacao;
    }//Construtor

    
    public String getSituacao() {
        return situacao;
    }//getSituacao()
    
    public void setSituacao(String situacao) {
		this.situacao = situacao;
	}//setSituacao()

    public static Situacao converterStringParaSituacao(String string) {
        if (string.isBlank()) {
        	return null;
        }
    	
    	for (Situacao situ : Situacao.values()) {
            if (situ.getSituacao().equalsIgnoreCase(string)) {
                return situ;
            }
        }
    	return null;
    }//converterStringParaSituacao()
    
    public static String[] getSituacoes() {
        Situacao[] situacoes = Situacao.values();
        List<String> nomesSitucoes = new ArrayList<>();

        for (Situacao situacao : situacoes) {
            nomesSitucoes.add(situacao.getSituacao());
        }

        return nomesSitucoes.toArray(new String[0]);
    }//getSituacoes()
    
    @Override
    public String toString() {
        return getSituacao();
    }//toString()
    
}//Situacao
