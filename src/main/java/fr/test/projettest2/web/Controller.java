package fr.test.projettest2.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

import org.jboss.weld.context.ejb.Ejb;

import fr.test.projettest2.domain.Product;
import fr.test.projettest2.service.product.ProductService;


@WebServlet(name="myServlet", urlPatterns={"/myservlet"})
public class Controller {

	@Ejb
	ProductService productService;
	
	
	@GET
	public void defaultPage(HttpServletRequest req, 
            HttpServletResponse res) throws IOException{
		
		
		Product product=productService.findById(Long.valueOf(req.getParameter("id")));
		res.getWriter().append(product.toString());
		res.getWriter().flush();
		res.getWriter().close();
		
	}
}
