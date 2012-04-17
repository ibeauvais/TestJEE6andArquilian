package fr.test.projettest2.Repository;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.test.projettest2.domain.Category;
@Singleton
public class CategoryRepository {
	


	@PersistenceContext
	private EntityManager em;
	
	
	
	public  List<Category> findByName(String name){
		CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Category> query = queryBuilder.createQuery(Category.class);
		Root<Category> root = query.from(Category.class);
		Predicate predicate = queryBuilder.equal(root.get("name"), name);
		query.where(predicate);
		
		TypedQuery<Category> q = em.createQuery(query); 
		
		return q.getResultList();
	}
	
	public List<Category>  findAll (){
		CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Category> query = queryBuilder.createQuery(Category.class);
		Root<Category> from = query.from(Category.class);
		query.select(from);
		TypedQuery<Category> q = em.createQuery(query); 
		
		return q.getResultList();
		
	}



	public void create(Category category) {
		em.persist(category);
		
	}

	public Category findById(Long idCategory) {
		return em.find(Category.class, idCategory);
	}

}
