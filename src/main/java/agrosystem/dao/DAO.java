package agrosystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> implements AutoCloseable {
	private Class<T> classe;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public DAO(Class<T> classe) throws PersistenceException {
		this.classe = classe;
		entityManagerFactory = Persistence.createEntityManagerFactory("agrosystem");
		entityManager = entityManagerFactory.createEntityManager();
	}//Construtor
	
	public void adiciona(T t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
	}//adiciona()
	
	public void altera(T t) {
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
	}//altera()
	
	public void remove(T t) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
	}//remove()
	
	public T buscaPorId(Long id) {
		return entityManager.find(classe, id);
	}//buscaPorId()
	
	public List<T> listaTodos(){
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> list = entityManager.createQuery(query).getResultList();
		return list;
	}//listaTodos()

	@Override
	public void close() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}//close()
}//DAO