package com.estore.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "PRODUCT")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private Double price;
	private String description;
	@Column(name = "category_id")
	private int categoryId;
	@Lob
	private Byte[] image;
	
	public Product() {
        super();
    }
	
	public String getName(){
		return name;
	}
	
	@Override
    public String toString() {
        return "Product: " + name;
    }
}

