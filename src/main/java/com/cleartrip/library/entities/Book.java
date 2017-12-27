package com.cleartrip.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	
    private String name;
    private String author;
    private int totalVolume;
    private int availableVolume;
    
    public Book(){
		super();
	}
	public Book(long id){
		super();
		this.id = id;
	}
	
	public Book(String name){
		super();
		this.name = name;
	}
    
    
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
	public int getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}
	public int getAvailableVolume() {
		return availableVolume;
	}
	public void setAvailableVolume(int availableVolume) {
		this.availableVolume = availableVolume;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", totalVolume=" + totalVolume
				+ ", availableVolume=" + availableVolume + "]";
	}
       
    
}
