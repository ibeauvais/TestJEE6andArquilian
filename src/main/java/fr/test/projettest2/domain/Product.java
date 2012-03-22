package fr.test.projettest2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;




@Entity
@NamedQueries({
    @NamedQuery(name = Product.QUERY_FIND_ALL, query = "SELECT p FROM Product p"),
    @NamedQuery(name = Product.QUERY_FIND_BY_NAME, query = "SELECT p FROM Product p WHERE p.name LIKE :name")
})
public class Product {
	
	public static final String QUERY_FIND_ALL="Product.findAll";
	public static final String  QUERY_FIND_BY_NAME="Product.findByName";
	
	
	public Product(String name, double price) {
		this.name=name;
		this.price=BigDecimal.valueOf(price);
		
	}
	
	public Product(){
		
	}
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private BigDecimal price;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="FK_CATEGORY")
	private List<Category> categories;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<Category> getCategories() {
		if(categories==null)
			return Collections.emptyList();
		return categories;
	}
	
	
	public void addCategory(Category category) {
		if(categories==null)
			categories=new ArrayList<Category>();
		
		categories.add(category);
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", name=")
				.append(name).append(", price=").append(price)
				.append(", categories=").append(categories).append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
	
	

}
