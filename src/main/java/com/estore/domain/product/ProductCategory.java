package com.estore.domain.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "CATEGORY")
public class ProductCategory implements Serializable, IProductCategory {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String tags;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getTags() {
		return tags;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", tags=" + tags + '}';
    }

}
