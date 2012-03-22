package fr.test.projettest2.test;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.runner.RunWith;

import fr.test.projettest2.Repository.CategoryRepository;
import fr.test.projettest2.Repository.ProductRepository;
import fr.test.projettest2.db.importData.DataSourceImport;
import fr.test.projettest2.domain.Category;
import fr.test.projettest2.domain.Product;
import fr.test.projettest2.service.product.ProductService;

@RunWith(Arquillian.class)
public abstract class AbstractTest {

	 @Deployment
	    public static JavaArchive createDeployment() {
	        return ShrinkWrap.create(JavaArchive.class)
	            .addClasses(ProductService.class,CategoryRepository.class,ProductRepository.class, Product.class,Category.class,DataSourceImport.class)
	            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
	            .addAsManifestResource(
	                    "META-INF/persistence.xml",
	                   "persistence.xml");


	   }


	   
	
	@Inject
	private DataSourceImport dataSourceImport;
	


	
	
	@Before
	public void initTest(){
		dataSourceImport.importData();
	}
	
	
	
}
