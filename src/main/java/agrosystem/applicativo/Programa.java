package agrosystem.applicativo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import agrosystem.dominio.Bovino;
import agrosystem.dominio.enumeracao.Raca;
import agrosystem.dominio.enumeracao.Sexo;
import agrosystem.dominio.enumeracao.Situacao;

public class Programa {

	public static void main(String[] args) {
		  // Criando instância de Bovino 1
        Bovino bovino1 = new Bovino("123ABC", "Vaca1", Situacao.MORTO, Sexo.FEMININO, "456DEF", "789GHI", Raca.HOLANDES, LocalDate.of(2018, 5, 20), LocalDate.of(2023, 2, 15), LocalDate.of(2023, 10, 10));
        
        // Criando instância de Bovino 2
        Bovino bovino2 = new Bovino("456DEF", "Vaca2", Situacao.SECA, Sexo.FEMININO, "789GHI", "123ABC", Raca.GIROLANDO, LocalDate.of(2017, 10, 10), LocalDate.of(2022, 6, 25), LocalDate.of(2022, 12, 20));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agrosystem");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bovino1);
        em.persist(bovino2);
        em.getTransaction().commit();
        em.close();
        emf.close();
        

	}//main()

}//Programa
