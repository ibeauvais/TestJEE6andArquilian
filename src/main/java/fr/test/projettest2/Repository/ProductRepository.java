package fr.test.projettest2.Repository;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.test.projettest2.domain.Product;
@Singleton
public class ProductRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void create(Product product){
		
		 em.persist(product);
		
	}
	
	
	public Product findById(Long id){
		
		return em.find(Product.class, id);
		
	}
	
	public List<Product> findByName(){
		
		TypedQuery<Product> query = em.createNamedQuery(Product.QUERY_FIND_BY_NAME,
				Product.class);
		return  query.getResultList();
		
	}
	
	
	public List<Product> findAll(){
		
		TypedQuery<Product> query = em.createNamedQuery(Product.QUERY_FIND_ALL,
				Product.class);
		return  query.getResultList();
		
	}
	
}
