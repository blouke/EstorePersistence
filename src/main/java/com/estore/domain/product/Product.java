package com.estore.domain.product;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "PRODUCT")
@Cacheable(false)
public class Product implements Serializable, IProduct{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Double price;
	private String description;
	
	@Column(name = "category_id")
	@NotNull
	private Long categoryId;
	
	@NotNull
	private String image;
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", category id=" + categoryId + ", image=" + image + '}';
    }

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Long getCategoryId() {
		return categoryId;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setCategoryId(Long id) {
		this.categoryId = id;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}
}

