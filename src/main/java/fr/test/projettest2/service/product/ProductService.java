package fr.test.projettest2.service.product;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.google.common.base.Preconditions;

import fr.test.projettest2.Repository.CategoryRepository;
import fr.test.projettest2.Repository.ProductRepository;
import fr.test.projettest2.domain.Category;
import fr.test.projettest2.domain.Product;


@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductService {
	
	
	@Inject
	private CategoryRepository categoryRepository;

	@Inject
	private ProductRepository productRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Product createProduct(String name,double price,Long idCategory){
		Preconditions.checkNotNull(name,"product name is null");
		
		Product productToCreate=new Product(name,price);
		Category category=getCategory(idCategory);
		productToCreate.addCategory(category);
		
		productRepository.create(productToCreate);
		
		return productToCreate;
		
	}
	
	

	public List<Product> findAll(){
		
		return productRepository.findAll();
		
	}
	
	
	public Product findById(Long id){
		Preconditions.checkNotNull(id,"product id is null");
		return productRepository.findById(id);
		
	}



	private Category getCategory(Long idCategory) {
		
		if(idCategory==null)
			return null;
		
		return categoryRepository.findById(idCategory);
	}
	
	

}
