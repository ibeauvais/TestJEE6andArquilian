package fr.test.projettest2.db.importData;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import fr.test.projettest2.Repository.CategoryRepository;
import fr.test.projettest2.Repository.ProductRepository;
import fr.test.projettest2.domain.Category;
import fr.test.projettest2.domain.Product;






@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/myDb",
        className = "org.h2.Driver",
        url = "jdbc:h2:test" ,user ="sa",password = "1234"
)
public class DataSourceImport {

	
	 @Inject
	    private ProductRepository productRepository;
	 @Inject
	  private CategoryRepository categoryRepository;
	    
	    
	     @PostConstruct
	    public void importData() {
	    	 importDataIfNotExist();
	        
	    }

	    private void importDataIfNotExist() {

	    	importCategories();
	    	importProduct();
	       
	    }

		private void importCategories() {
			if(categoryRepository.findAll().size()==0){
				categoryRepository.create(new Category("Mobilier"));
		       }
			
		}

		private void importProduct() {
			if(productRepository.findAll().size()==0){
		    	  
		    	   List<Category> categories=categoryRepository.findByName("Mobilier");
		    	   Category mobilier=categories.get(0);
		    	    
		    	   Product chaise=new Product("Chaise",15.3);
		    	   chaise.addCategory(mobilier);
		    	   Product table=new Product("table",20.00);
		    	   table.addCategory(mobilier);
		    	   Product armoire=new Product("armoire",50.30);
		    	   armoire.addCategory(mobilier);
		    	   
		    	   
		    	   productRepository.create(chaise);
		    	   productRepository.create(table);
		    	   productRepository.create(armoire);
		       }
			
		}
}
