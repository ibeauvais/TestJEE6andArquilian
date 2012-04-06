package fr.test.projettest2.service.product;

import javax.ejb.EJB;

import org.junit.Assert;
import org.junit.Test;

import fr.test.projettest2.domain.Product;
import fr.test.projettest2.test.AbstractTest;


public class TestProductServiceTest extends AbstractTest{
	
	@EJB
	private ProductService productService;
	
	@Test
	public void TestCreate(){
		
		Product product=productService.createProduct("stylo",1.2, null);
		Assert.assertNotNull(product.getId());
		
	}
	
	@Test
	public void TestCreate2(){
		
		Product product=productService.createProduct("chaise",5.0, 1L);
		Assert.assertNotNull(product.getId());
		Product product2=productService.createProduct("table",6.0, 1L);
		Assert.assertNotNull(product2.getId());
	}

}
