package com.cleartrip.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.search.annotations.Field;
@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Field
    private String name;
    @Field
    private String author;
    @Field
    private int totalVolumn;
    @Field
    private int availableVolumn;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTotalVolumn() {
		return totalVolumn;
	}
	public void setTotalVolumn(int totalVolumn) {
		this.totalVolumn = totalVolumn;
	}
	public int getAvailableVolumn() {
		return availableVolumn;
	}
	public void setAvailableVolumn(int availableVolumn) {
		this.availableVolumn = availableVolumn;
	}
    
    
    
}
