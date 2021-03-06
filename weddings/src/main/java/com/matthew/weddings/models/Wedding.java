package com.matthew.weddings.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="weddings")
public class Wedding {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String wedderOne;
	@NotBlank
	private String wedderTwo;
	private Date date;
	private String address;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User planner;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "wedding_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> guests;
	public Wedding() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWedderOne() {
		return wedderOne;
	}
	public void setWedderOne(String wedderOne) {
		this.wedderOne = wedderOne;
	}
	public String getWedderTwo() {
		return wedderTwo;
	}
	public void setWedderTwo(String wedderTwo) {
		this.wedderTwo = wedderTwo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
